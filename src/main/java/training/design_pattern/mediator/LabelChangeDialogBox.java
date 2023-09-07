package training.design_pattern.mediator;

public class LabelChangeDialogBox
{
    Label label = new Label();

    TextSelection textSelection = new TextSelection();


    LabelChangeDialogBox()
    {
        textSelection.addEventHandler(this::textSelected);
    }

    private void textSelected()
    {
        label.setLabelText(textSelection.getText());
    }

    void simulateUserInteraction(){
        textSelection.setText("newSelectedText");
        System.out.println(label.getLabelText());
    }
}
