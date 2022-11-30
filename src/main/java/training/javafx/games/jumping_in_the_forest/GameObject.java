package training.javafx.games.jumping_in_the_forest;

import javafx.scene.shape.Rectangle;

import java.util.Objects;

abstract class GameObject
{
    Rectangle bounds;
  
    Rectangle getBounds()
    {
        return this.bounds;
    }
    
    double getMinX()
    {
        return this.bounds.getBoundsInParent().getMinX(); 
    }
    
    double getMaxX()
    {
        return this.bounds.getBoundsInParent().getMaxX(); 
    }
        
    double getMinY()
    {
        return this.bounds.getBoundsInParent().getMinY();
    }
    
    double getMaxY()
    {
        return this.bounds.getBoundsInParent().getMaxY();
    }
    
    String fromUrlOf(String path)
    {
        return Objects.requireNonNull(getClass().getResource(path))
                      .toString();
    }
}