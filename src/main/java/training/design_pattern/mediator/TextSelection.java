package training.design_pattern.mediator;

class TextSelection extends UIControl
{
    String text = "";


    public String getText()
    {
        return text;
    }

    void setText(String text)
    {
        this.text = text;
        notifyEventHandler();
    }
}
