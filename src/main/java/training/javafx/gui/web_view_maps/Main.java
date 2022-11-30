package training.javafx.gui.web_view_maps;

import java.net.URL;
import java.util.Objects;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
	
	  private Scene scene;
	    MyBrowser myBrowser;
	    double lat;
	    double lon;
	
	@Override
	public void start(Stage primaryStage) {
		try
		{
			myBrowser = new MyBrowser();
	        Scene scene = new Scene(myBrowser);

	        primaryStage.setScene(scene);
	        primaryStage.setWidth(1200);
	        primaryStage.setHeight(600);
	        primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

	
	 class MyBrowser extends Pane {


	        WebView webView = new WebView();
	        WebEngine webEngine = webView.getEngine();


	        public MyBrowser()
			{
				final URL urlGoogleMaps = getClass().getResource("map.html");
	            webEngine.load(Objects.requireNonNull(urlGoogleMaps)
									  .toExternalForm());
	            webEngine.setOnAlert(e -> System.out.println(e.toString()));
	            
	            getChildren().add(webView);

	            final TextField latitude = new TextField("" + 52.50591 * 1.00007);
	            final TextField longitude = new TextField("" + 13.29872 * 1.00007);
	            Button updateButton = new Button("Update");
	            updateButton.setOnAction(event -> {
					lat = Double.parseDouble(latitude.getText());
					lon = Double.parseDouble(longitude.getText());

					System.out.printf("%.2f %.2f%n", lat, lon);

					webEngine.executeScript("" +
						"window.lat = " + lat + ";" +
						"window.lon = " + lon + ";" +
						"document.goToLocation(window.lat, window.lon);"
					);
				});

	            
	            Button circleButton = new Button("Circle");
	            
	            circleButton.setOnAction(event -> {

					lat = Double.parseDouble(latitude.getText());
lon = Double.parseDouble(longitude.getText());
int radius =160;

webEngine.executeScript("" +
"window.lat = " + lat + ";" +
"window.lon = " + lon + ";" +
"var r="+radius+";"+
"document.goToLocationRadius(window.lat, window.lon,r);"
);
				
				
				});
	            
	            
	            
	            
	            HBox toolbar  = new HBox();
	            toolbar.getChildren().addAll(latitude, longitude, updateButton,circleButton);

	            getChildren().addAll(toolbar);

	        }
	    }
	public static void main(String[] args) {
		
		System.setProperty("java.net.useSystemProxies", "true");
		launch(args);
	}
}
