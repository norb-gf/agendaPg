package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
		loadView("/gui/AtividadesList.fxml",
				(AtividadesListController controller) -> {
					controller.setAtividadesService(new AtividadesService());
					controller.updateTableView();
				});
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
		loadView("/gui/Sobre.fxml", x -> {});
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

	// <T> ver conceito de Generics
	// <Consumer> ver conceito de expressões lambda  
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction)  {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);

		} catch (IOException e) {
			Alerts.showAlert("IOException", "Erro no loading View", e.getMessage(), AlertType.ERROR);
		}
	}
}
