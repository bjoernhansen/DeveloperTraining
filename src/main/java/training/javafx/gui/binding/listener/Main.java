package training.javafx.gui.binding.listener;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;

import java.util.Objects;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css"))
											  .toExternalForm());
			Button b1 = new Button("+1");
			Button b2 = new Button("-1");
			ProgressBar pb = new ProgressBar();
			
		
			Temperatur temp = new Temperatur();
			
			b1.setOnAction(e-> temp.setGrad(temp.getGrad()+0.1F));
			
			
			b2.setOnAction(e-> temp.setGrad(temp.getGrad()-0.1F));
			
			//------------------------------------
			
			//pb.progressProperty().bind(temp.gradProperty());
			
			// Listener 
			
			
//			temp.gradProperty().addListener(new ChangeListener<Number>() {
//
//				@Override
//				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//					// TODO Auto-generated method stub
//					
//				}
//
//			});
			temp.gradProperty().addListener((a,b,newValue)->{
				if(newValue!=null) {
					pb.setProgress(newValue.doubleValue());
				}
			});
			
			
			
			root.setTop(b1);
			root.setBottom(b2);
			root.setCenter(pb);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
