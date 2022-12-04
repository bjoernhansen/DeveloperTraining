package training.javafx.games.jumping_in_the_forest;

import training.javafx.games.algebra.Math;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


class Plateau extends GameObject
{
    private static final double
        PLATEAU_HEIGHT = 88,
        PLATEAU_WIDTH = 417,
        BORDER_DISTANCE = 30,
        MIN_STRETCHING_FACTOR = 0.45;
    
    private static final String
            PLATEAU_1_IMAGE_PATH =  "/pictures/plateau_1.png",
            PLATEAU_2_IMAGE_PATH =  "/pictures/plateau_2.png";
    
    private final double
        stretchingFactor;
    
    private final Rectangle
        view;
 
    
    Plateau()
    {           
        this.stretchingFactor = 0.8 * Math.random.nextDouble() + MIN_STRETCHING_FACTOR;
        
        this.view =   new Rectangle(0, 0, this.stretchingFactor * PLATEAU_WIDTH, PLATEAU_HEIGHT);
        this.bounds = new Rectangle(0, 0, this.stretchingFactor * (PLATEAU_WIDTH - 2 * BORDER_DISTANCE), 1);
                
        ImagePattern imagePattern = new ImagePattern(
                new Image(fromUrlOf(random_plateau_image())), 0, 0, this.view.getWidth(), PLATEAU_HEIGHT, false);
        
        this.view.setFill(imagePattern);   
        this.bounds.setFill(new Color(0,0,0,0));
    }
        
    private static String random_plateau_image()
    {
        if(Math.random.nextBoolean())
        {
            return PLATEAU_1_IMAGE_PATH;
        }
        return PLATEAU_2_IMAGE_PATH;
    }

    Node getView()
    {       
        return this.view;
    }

    void moveTo(double x, double y)
    {
        this.getView().setTranslateX(x);
        this.getView().setTranslateY(y);
        
        this.getBounds().setTranslateX(x + this.stretchingFactor * BORDER_DISTANCE);
        this.getBounds().setTranslateY(y + 20);     
    }

    boolean isBelow(Boy boy)
    {
        return     boy.getMaxX() >= this.getMinX()
                && boy.getMinX() <= this.getMaxX()
                && boy.getMaxY() <= this.getMinY();
    }
}