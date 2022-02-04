package com.javafx.gui.tree_view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class SampleController  {
	
    @FXML
    private TreeView<String> treeView;

    @FXML
    void initialize() {
    	System.out.println("init..");
    	Platform.runLater( ()->{
    		
    		TreeItem<String> rootItem = new TreeItem<>("root");
    		TreeItem<String> item1 = new TreeItem<>("item1");
    		TreeItem<String> item2 = new TreeItem<>("item2");
    		TreeItem<String> item1a = new TreeItem<>("item1a");
    		
    		rootItem.getChildren().add(item1);
    		item1.getChildren().add(item1a);
    		rootItem.getChildren().add(item2);
    		rootItem.setExpanded(true);
    		treeView.setRoot(rootItem);
    	} );
    }
}