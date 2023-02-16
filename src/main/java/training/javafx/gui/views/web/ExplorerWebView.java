package training.javafx.gui.views.web;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ExplorerWebView extends Application {

	private final TextField tf = new TextField();
	WebView webView;
	WebEngine engine;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("InternetTerminator");
			final double w = Screen.getPrimary().getVisualBounds().getWidth();
			final double h = Screen.getPrimary().getVisualBounds().getHeight();

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, w, h);
			Button saveBTN = new Button("Save");
			// --WebView
			webView = new WebView();
			engine = webView.getEngine();

			// --event
			tf.setOnKeyPressed(event -> {
				if (event.getCode() == KeyCode.ENTER) {
					engine.load("http://" + tf.getText());

				}
			});

			saveBTN.setOnAction(event -> {

				System.out.println("finished loading");
				org.w3c.dom.Document xmlDom = engine.getDocument();
				System.out.println(xmlDom);

				try {
					TransformerFactory transformerFactory = TransformerFactory
							.newInstance();
					Transformer transformer = transformerFactory
							.newTransformer();
					StringWriter stringWriter = new StringWriter();
					transformer.transform(
							new DOMSource(engine.getDocument()),
							new StreamResult(stringWriter));
					String xml = stringWriter.getBuffer().toString();
					PrintWriter out = new PrintWriter("logs/file.html");
					out.println(xml);
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			root.setTop(tf);
			root.setCenter(webView);
			Button b = new Button("Scroll");

			b.setOnAction(event -> {
				engine.setJavaScriptEnabled(true);
				engine.executeScript("window.scrollTo('700', '300 ')");
			});

			root.setBottom(b);
			root.setRight(saveBTN);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
