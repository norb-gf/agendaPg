package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.entities.Bancos;
import models.exceptions.ValidationException;
import models.services.BancosService;

public class BancosFormController implements Initializable {

	private Bancos entity;
	private BancosService service;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	

	@FXML
	private TextField txtId;
	@FXML
	private TextField txtTipo;
	@FXML
	private TextField txtCod;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtAg;
	@FXML
	private TextField txtTitular;
	@FXML
	private TextField txtStatus;

	@FXML
	private Label lblErroTipo;
	@FXML
	private Label lblErroCod;
	@FXML
	private Label lblErroNome;
	@FXML
	private Label lblErroAg;
	@FXML
	private Label lblErroTitular;
	@FXML
	private Label lblErroStatus;

	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnCancelar;

	@FXML
	public void onBtnSalvarAction(ActionEvent event) {
		System.out.println("btnsalvarAction cabec");
		if (entity == null) {
			System.out.println("entity null");
			throw new IllegalStateException("onBtnSalvarAction entity null");
		}
		if (service == null) {
			System.out.println("service null");
			throw new IllegalStateException("onBtnSalvarAction service null");
		}
		try {
			System.out.println("try cabec");
			entity = getFormData();
			System.out.println("antes do or_update");
			service.saveOrUpdate(entity);
			System.out.println("apos update");
			notifyDataChangeListeners();
			System.out.println("antes do close");
			Utils.currentStage(event).close();
		}
		catch (DbException e) {
			Alerts.showAlert("Erro na criação do objeto", null, e.getMessage(), AlertType.ERROR);
		}
		catch (ValidationException e) {
			setErrorMessages(e.getErrors());		
		}	
	};

	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
		
	}

	private Bancos getFormData() {

		Bancos obj = new Bancos();
		
		ValidationException exception = new ValidationException("Erro de Validação except");
		
		obj.setId(Utils.tryParseToInt(txtId.getText())); 
		obj.setTipo(txtTipo.getText());
		obj.setCod(txtCod.getText());

		if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
			exception.addError("errNome", "O campo é obrigatorio");
		}
		obj.setNome(txtNome.getText());
		obj.setAg(txtAg.getText());
		obj.setTitular(txtTitular.getText());
		obj.setStatus(txtStatus.getText());
		
		if (exception.getErrors().size() > 0) {
			throw exception;
		}
		return obj;
	}

	@FXML
	public void onBtnCancelarAction(ActionEvent event) {
		Utils.currentStage(event).close();
	};

	public void setBancos(Bancos entity) {
		this.entity = entity;
	}

	public void setBancosService(BancosService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	
	
	/*
	 * private void keyPressed(KeyEvent evt) { String caracteres = "0987654321";
	 * System.out.println("evt0: " + evt.getText());
	 * 
	 * if (!caracteres.contains(evt.getText())) {
	 * System.out.println("passei letra"); evt.consume(); }
	 * System.out.println("passei depois"); System.out.println("evt: " + evt);
	 * System.out.println("txtcod= " + txtCod.getText()); evt.consume(); }
	 */

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldInteger(txtCod);
		Constraints.setTextFieldInteger(txtTipo);
		Constraints.setTextFieldMaxLength(txtTipo, 1);
		Constraints.setTextFieldMaxLength(txtCod, 3);
		Constraints.setTextFieldMaxLength(txtNome, 20);
		Constraints.setTextFieldMaxLength(txtAg, 6);
		Constraints.setTextFieldMaxLength(txtTitular, 15);
		Constraints.setTextFieldMaxLength(txtStatus, 15);
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Erro. updateFormData entity null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtCod.setText(entity.getCod());
		txtTipo.setText(entity.getTipo());
		txtNome.setText(entity.getNome());
		txtAg.setText(entity.getAg());
		txtTitular.setText(entity.getTitular());
		txtStatus.setText(entity.getStatus());
	}

	private void setErrorMessages(Map<String, String> errors) {
		Set<String> fields = errors.keySet();

		if (fields.contains("errNome")) {
			lblErroNome.setText(errors.get("errNome"));
		}
	
	}
	
	
}
