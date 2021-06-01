package com.javafx.games.jumping_in_the_forest;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


class BoyAnimator
{
    private static final int 
        COLUMNS = 8,
        COUNT = 8,
        OFFSET_X = 0,
        OFFSET_Y = 0,
        WIDTH = 108,
        HEIGHT = 140;    
    
    private SpriteAnimation animation;
    
    
    BoyAnimator(ImageView view)
    {
        this.animation = new SpriteAnimation(   
                view,
                Duration.millis(1000), // TODO Konstante festlegeb
                COUNT, 
                COLUMNS, 
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT);

        this.animation.setCycleCount(Animation.INDEFINITE);
        this.animation.play();        
    }
    
    void pause()
    {
        this.animation.pause();
    }
    
    void play()
    {
        this.animation.play();
    }

    void fitTo(boolean rightwards)
    {
        this.animation.setOffsetY(rightwards ? 0 : 140);
    }
}
