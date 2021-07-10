package com.javafx.games.jumping_in_the_forest;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


class SpriteAnimation extends Transition
{
    private ImageView 
        imageView;
    
    private int 
        count,
        columns,
        offsetX,
        offsetY,
        width,
        height,
        lastIndex;

    
    SpriteAnimation( ImageView imageView, 
                            Duration duration, 
                            int count,
                            int columns, 
                            int offsetX, int offsetY, 
                            int width,   int height)
    {
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double k)
    {
        final int index = Math.min((int)Math.floor(k * this.count), this.count - 1);
        if (index != this.lastIndex)
        {
            final int x = (index % this.columns) * this.width + this.offsetX;
            final int y = (index / this.columns) * this.height + this.offsetY;
            this.imageView.setViewport(new Rectangle2D(x, y, this.width, this.height));
            this.lastIndex = index;
        }
    }
    
    void setOffsetY(int offsetY)
    {
        this.offsetY = offsetY;
    }    
}