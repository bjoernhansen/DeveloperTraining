package training.javafx.service.example;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class Main1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TilePane root = new TilePane();
			Scene scene = new Scene(root,400,400);
			Label label1 = new Label();
			Label label2 = new Label();
			ProgressIndicator pi = new ProgressIndicator();
			Button button = new Button("Start");
			
			button.setOnAction(e->{
				// hier Task und Thread erzeugen / starten
				Task<String>  task = createTask();
				Thread t = new Thread(task);
				t.setDaemon(true);
				t.start();
				label1.textProperty().bind(task.messageProperty());// updateMessage
				label2.textProperty().bind(task.valueProperty());// updateValue
				pi.progressProperty().bind(task.progressProperty());//updateProgress
			});
			root.getChildren().addAll(button,pi,label1,label2);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Task<String> createTask(){
		return new Task<>()
		{
			@Override
			protected String call()
			{
				updateMessage("call...");
				final long MAX = 10_000_000;
				long result = 0;
				for (int i = 0; i <= MAX; i++)
				{
					result += i;
					updateValue("" + result);// Zwischenergebnis
					updateProgress(i, MAX);// Fortschritt
				}
				updateMessage("call end...");
				return "Result: " + result;  // value
			}
		};
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
