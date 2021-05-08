package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.entities.Bancos;

public class BancosFormController implements Initializable {

	private Bancos entity;

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
	public void onBtnSalvarAction() {
		System.out.println("onBtnSalvarAction");
	};

	@FXML
	public void onBtnCancelarAction() {
		System.out.println("onBtnCancelarAction");
	};

	public void setBancos(Bancos entity) {
		this.entity = entity;
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
