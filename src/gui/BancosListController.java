package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.entities.Bancos;
import models.services.BancosService;

public class BancosListController implements Initializable, DataChangeListener {

	private BancosService service;

	@FXML
	private TableView<Bancos> tableViewBancos;
	@FXML
	private TableColumn<Bancos, Integer> tableColumnId;
	@FXML
	private TableColumn<Bancos, String> tableColumnTipo;
	@FXML
	private TableColumn<Bancos, String> tableColumnCod;
	@FXML
	private TableColumn<Bancos, String> tableColumnNome;
	@FXML
	private TableColumn<Bancos, String> tableColumnAg;
	@FXML
	private TableColumn<Bancos, Float> tableColumnTitular;
	@FXML
	private TableColumn<Bancos, String> tableColumnStatus;
	@FXML
	private TableColumn<Bancos, Bancos> tableColumnEDIT;
	@FXML
	private TableColumn<Bancos, Bancos> tableColumnREMOVE;

	@FXML
	private Button btNovo;

	private ObservableList<Bancos> obsList;

	@FXML
	private void onBtNovoAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Bancos obj = new Bancos();
		createDialogForm(obj, "/gui/BancosForm.fxml", parentStage);
	}

	public void setBancosService(BancosService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {

		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tableColumnCod.setCellValueFactory(new PropertyValueFactory<>("cod"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnAg.setCellValueFactory(new PropertyValueFactory<>("ag"));
		tableColumnTitular.setCellValueFactory(new PropertyValueFactory<>("titular"));
		tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewBancos.prefHeightProperty().bind(stage.heightProperty());

	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service Bancos estava vazio");
		}
		List<Bancos> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewBancos.setItems(obsList);
		initEditButtons();
		initRemoveButtons();
	}

	private void createDialogForm(Bancos obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			BancosFormController controller = loader.getController();
			controller.setBancos(obj);
			controller.setBancosService(new BancosService());
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Informe os dados do Banco");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro createDialogForm", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		updateTableView();
	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Bancos, Bancos>() {
			private final Button button = new Button("Edit");

			@Override
			protected void updateItem(Bancos obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> createDialogForm(obj, "/gui/BancosForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Bancos, Bancos>() {
			private final Button button = new Button("Del");

			@Override
			protected void updateItem(Bancos obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}

	private void removeEntity(Bancos obj) {
		Optional<ButtonType> result = Alerts.showConfirmation(" Aten??o!! ", "Confirma a exclus?o ?? ");

		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("removeEntity service null");
			}
			try {
				service.remove(obj);
				updateTableView();
			} catch (DbIntegrityException e) {
				Alerts.showAlert("Erro delecao Bancos", null, e.getMessage(), AlertType.ERROR);
			}
		}

	}
}
