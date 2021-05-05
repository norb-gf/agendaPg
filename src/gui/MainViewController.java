package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import models.services.AtividadesService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemAtividades;
	
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

	public void onMenuItemAtividadesListAction() {
//		loadView("/gui/AtividadesList.fxml");
		loadView2("/gui/AtividadesList.fxml");
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
		loadView("/gui/Sobre.fxml");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IOException", "Erro no loading View", e.getMessage(), AlertType.ERROR);
		}
	}

// temporario ============================**
	
	private synchronized void loadView2(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			AtividadesListController controller = loader.getController();
			controller.setAtividadesService(new AtividadesService());
			controller.updateTableView();

		} catch (IOException e) {
			Alerts.showAlert("IOException", "Erro no loading View", e.getMessage(), AlertType.ERROR);
		}
	}
// temporario ****************************==
	

}
