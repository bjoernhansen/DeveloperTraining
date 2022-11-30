package training.javafx.gui.canvas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class SampleController  implements Initializable{

	@FXML private Canvas canvas;
	


	private static List<ColorPoint> createPoints(int count){
		List<ColorPoint> points = new ArrayList<>();
		Random rand = new Random();
		
		for (int i = 0; i < count; i++) {
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
			int b = rand.nextInt(255);
			points.add(new ColorPoint(rand.nextInt(300), rand.nextInt(300),Color.rgb(r,g,b)));

		}
		return points;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GraphicsContext gc = canvas.getGraphicsContext2D();


		
		List<ColorPoint> pointList = createPoints(10000);
		for (ColorPoint colorPoint : pointList) {
			gc.setStroke(colorPoint.getC());
			gc.setFill(colorPoint.getC());
		//	gc.strokeOval(colorPoint.getX(), colorPoint.getY(),5 , 5);
			gc.fillOval(colorPoint.getX(), colorPoint.getY(),6 , 6);
		
			
		}

	}
	
	public static void main(String[] args) {
		System.out.println(createPoints(50));
	}
}
