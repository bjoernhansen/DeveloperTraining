package com.javafx.gui.binding.color_picker;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class SampleController implements Initializable
{
    @FXML
    ColorPicker colorPicker;
    @FXML
    Rectangle rect;

    // fillProperty //valueProperty

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        rect.fillProperty().bind(colorPicker.valueProperty());
    }

}
