package training.design_pattern.mediator;

public class Label extends UIControl
{
    private String labelText = "";


    void setLabelText(String labelText)
    {
        this.labelText = labelText;
    }

    String getLabelText()
    {
        return labelText;
    }
}
