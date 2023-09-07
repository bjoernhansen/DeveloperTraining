package training.design_pattern.state;

import java.util.function.Supplier;


public enum ToolType implements Tool
{
    SELECTOR(()->"Release Selector", ()->"Activate Selector"),
    BRUSH(()->"Release Brush", ()->"Activate Brush"),
    ERASER(()->"Release Eraser", ()->"Activate Eraser");


    private final Supplier<String>
        mouseUpAction;

    private final Supplier<String>
        mouseDownAction;


    ToolType(Supplier<String> mouseUpAction, Supplier<String> mouseDownAction)
    {
        this.mouseUpAction = mouseUpAction;
        this.mouseDownAction = mouseDownAction;
    }

    @Override
    public void mouseUpAction() {
        System.out.println(mouseUpAction.get());
    }

    @Override
    public void mouseDownAction() {
        System.out.println(mouseDownAction.get());
    }
}
