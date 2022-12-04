package training.javafx.service;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TilePane root = new TilePane();
			Scene scene = new Scene(root,400,400);
			Label label1 = new Label();
			Label label2 = new Label();
			ProgressIndicator pi = new ProgressIndicator();
			Button b1 = new Button("Start");
			
			MyService service = new MyService();
			
			label1.textProperty().bind(service.messageProperty());// updateMessage
			label2.textProperty().bind(service.valueProperty());// updateValue
			pi.progressProperty().bind(service.progressProperty());//updateProgress
			
			// hier Binding ODER Listener
			service.valueProperty().addListener((obsValue,oldValue,newValue)->{
				if(newValue!=null) {
					// label2.setText(newValue);
				}
			});
			
			b1.setOnAction(e-> service.restart());
		
			service.setOnSucceeded(event -> System.out.println("Service erfolgreich fertig..."));
			root.getChildren().addAll(b1,pi,label1,label2);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
