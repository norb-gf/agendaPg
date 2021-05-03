package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemFornecedores;

	@FXML
	private MenuItem menuItemContasBancarias;
	
	@FXML
	private MenuItem menuItemMesAnterior;
	
	@FXML
	private MenuItem menuItemMesAtual;
	
	@FXML
	private MenuItem menuItemProxMes;
	
	@FXML
	private MenuItem menuItemAgendaPadrao;
	
	@FXML
	private MenuItem menuItemAbout;
	
	public void onMenuItemFornecedoresAction() {
		System.out.println("onMenuItemFornecedoresAction");
	}
	
	public void onMenuItemContasBancariasAction() {
		System.out.println("onMenuItemContasBancariasAction");
	}
	
	public void onMenuItemMesAnteriorAction() {
		System.out.println("onMenuItemMesAnteriorAction");
	}	
	
	public void onMenuItemMesAtualAction() {
		System.out.println("onMenuItemMesAtualAction");
	}	
	
	public void onMenuItemProxMesAction() {
		System.out.println("onMenuItemProxMesAction");
	}	
	
	public void onMenuItemAgendaPadraoAction() {
		System.out.println("onMenuItemAgendaPadraoAction");
	}	
	
	public void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
	}	
	
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

}
