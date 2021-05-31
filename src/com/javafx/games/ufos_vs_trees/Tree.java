package com.javafx.games.ufos_vs_trees;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


class Tree extends GameObject
{
    private static final String STONE_CIRCLE_IMAGE_PATH = "images/stone_circle.png";
    private static final String TREE_IMAGE_PATH [] = {  "images/tree_1.png",
                                                        "images/tree_2.png",
                                                        "images/tree_3.png"};
    
    Tree()
    {
        super(new Circle(50, 50, 50, Color.RED));
        Image treeImage =  new Image(fromUrlOf(randomTreeName()));
        ((Circle)this.getShape()).setFill(new ImagePattern(
               treeImage, 0, 0, 100, 100, false));
    }

    private static String randomTreeName()
    {
        return TREE_IMAGE_PATH[(int) (Math.random() * 3)];
    }

    @Override
    void handleCollision()
    {
        this.setAlive(false);
        ImagePattern imagePattern = new ImagePattern(
                new Image(fromUrlOf(STONE_CIRCLE_IMAGE_PATH)), 0, 0, 100, 100, false);
        ((Circle)this.getShape()).setFill(imagePattern);
    }
}