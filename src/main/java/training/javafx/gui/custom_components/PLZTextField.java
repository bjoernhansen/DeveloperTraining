package training.javafx.gui.custom_components;

import javafx.scene.control.TextField;

public class PLZTextField extends TextField {

	@Override
	public void replaceText(int start, int end, String text) {
		System.out.println("text: " + text);
		System.out.println("getText():" + getText());
		if (text.matches("\\d") && getText().length() < 5 || text.isEmpty()) {

			super.replaceText(start, end, text);
		}

	}

	@Override
	public void replaceSelection(String replacement) {
		if (replacement.matches("\\d") && getText().length() < 5  || replacement.isEmpty()) {
			super.replaceSelection(replacement);
		}
	}
}
