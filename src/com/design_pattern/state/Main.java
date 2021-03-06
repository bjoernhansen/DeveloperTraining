package com.design_pattern.state;

public class Main {

    public static void main(String[] args) {

        PaintWindow paintWindow = new PaintWindow(ToolType.BRUSH);

        paintWindow.mouseDownAction();

        paintWindow.setTool(ToolType.ERSASER);

        paintWindow.mouseDownAction();
        paintWindow.mouseUpAction();
    }
}
