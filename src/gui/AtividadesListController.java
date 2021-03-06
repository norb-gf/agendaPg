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
import models.entities.Atividades;
import models.services.AtividadesService;

public class AtividadesListController implements Initializable {

	private AtividadesService service;
	
	@FXML
	private TableView<Atividades> tableViewAtividades;		
	@FXML
	private TableColumn<Atividades, Integer> tableColumnId;
	@FXML
	private TableColumn<Atividades, String> tableColumnSt;
	@FXML
	private TableColumn<Atividades, String> tableColumnDiaPg;
	@FXML
	private TableColumn<Atividades, String> tableColumnTitular;
	@FXML
	private TableColumn<Atividades, String> tableColumnDescr;
	@FXML
	private TableColumn<Atividades, Float> tableColumnValor;
	@FXML
	private TableColumn<Atividades, Boolean> tableColumnBoleto;
	@FXML
	private TableColumn<Atividades, Boolean> tableColumnComprovPg;
	@FXML
	private Button btNovo;

	private ObservableList<Atividades> obsList;
	
	@FXML
	private void onBtNovoAction() {
		System.out.println("onBtNovoAction");
	}
	
	public void setAtividadesService(AtividadesService service) {
		 this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {

		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnSt.setCellValueFactory(new PropertyValueFactory<>("st"));
		tableColumnDiaPg.setCellValueFactory(new PropertyValueFactory<>("diaPg"));
		tableColumnTitular.setCellValueFactory(new PropertyValueFactory<>("titular"));
		tableColumnDescr.setCellValueFactory(new PropertyValueFactory<>("descr"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tableColumnBoleto.setCellValueFactory(new PropertyValueFactory<>("boleto"));
		tableColumnComprovPg.setCellValueFactory(new PropertyValueFactory<>("comprovPg"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewAtividades.prefHeightProperty().bind(stage.heightProperty());
	
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service Atividades estava vazio");
		}
		List <Atividades> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewAtividades.setItems(obsList);	
	}
}

