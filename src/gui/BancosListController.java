package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.Bancos;
import models.services.BancosService;

public class BancosListController implements Initializable {

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
	private TableColumn<Bancos, Boolean> tableColumnStatus;
	@FXML
	private Button btNovo;

	private ObservableList<Bancos> obsList;
	
	@FXML
	private void onBtNovoAction() {
		System.out.println("onBtNovoAction");
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
		List <Bancos> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewBancos.setItems(obsList);	
	}
}

