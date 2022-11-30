package training.javafx.gui.images;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;

public class SampleController {

	@FXML ImageView imageView;
	@FXML Slider slider;

	@FXML public void action(ActionEvent event) {
		imageView.setFitWidth(100);
		imageView.setPreserveRatio(true);
	}
	
	@FXML
	public void initialize() {
		System.out.println("init...");
		slider.valueProperty().addListener( (a,b,newValue)->{
			
			System.out.println(newValue);
			imageView.setOpacity(newValue.doubleValue()/100);
			
		} );
	}
	
}
