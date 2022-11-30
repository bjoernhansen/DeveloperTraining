/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package training.javafx.gui.new_window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class MainController {

	@FXML // fx:id="mainLabel"
	private Label mainLabel; // Value injected by FXMLLoader

	public Label getMainLabel() {
		return mainLabel;
	}

	public void setMainLabel(Label mainLabel) {
		this.mainLabel = mainLabel;
	}

	@FXML
	void newWindowAction(ActionEvent event) {
		try {

			Stage stage = new Stage();
			stage.initOwner(mainLabel.getScene().getWindow());
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setOpacity(1);
			stage.setTitle("new Window");
			stage.setX(100);

			Parent pane2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Window2.fxml")));


			if (pane2 != null) {
				Scene scene = new Scene(pane2);
				scene.setUserData(this);// MainController Instance to  Window2Controller
				stage.setScene(scene);
				stage.show();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void initialize() {
	System.out.println("init main Controller...");
	}

}