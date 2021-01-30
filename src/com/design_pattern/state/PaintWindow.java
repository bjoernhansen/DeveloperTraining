package com.design_pattern.state;

public class PaintWindow implements Tool{

    private Tool tool;


    public PaintWindow(Tool tool) {
        this.tool = tool;
    }

    @Override
    public void mouseUpAction() {
        tool.mouseUpAction();
    }

    @Override
    public void mouseDownAction() {
        tool.mouseDownAction();
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
