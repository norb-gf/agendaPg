package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.entities.Bancos;
import models.services.BancosService;

public class BancosFormController implements Initializable {

	private Bancos entity;
	private BancosService service;

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
		if (entity == null) {
			throw new IllegalStateException("onBtnSalvarAction entity null");
		}
		if (service == null) {
			throw new IllegalStateException("onBtnSalvarAction service null");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			Utils.currentStage(event).close();
		}
		catch (DbException e) {
			Alerts.showAlert("Erro na criação do objeto", null, e.getMessage(), AlertType.ERROR);
		}
	};

	private Bancos getFormData() {
		Bancos obj = new Bancos();
		obj.setId(Utils.tryParseToInt(txtId.getText())); 
		obj.setTipo(txtTipo.getText());
		obj.setCod(txtCod.getText());
		obj.setNome(txtNome.getText());
		obj.setAg(txtAg.getText());
		obj.setTitular(txtTitular.getText());
		obj.setStatus(txtStatus.getText());
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
		txtId.setText(entity.getCod());
		txtId.setText(entity.getTipo());
		txtId.setText(entity.getNome());
		txtId.setText(entity.getAg());
		txtId.setText(entity.getTitular());
		txtId.setText(entity.getStatus());
	}

}
