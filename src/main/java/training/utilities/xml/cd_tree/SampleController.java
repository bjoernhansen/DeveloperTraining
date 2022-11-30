package training.utilities.xml.cd_tree;

import javafx.fxml.FXML;
import javafx.scene.control.TreeView;

public class SampleController {

	@FXML private TreeView<String> cdTreeView;
	
	@FXML
	void initialize() {
		System.out.println("init...");
		
		this.cdTreeView.setRoot(CDTreeCreator.createTree("src/com/utilities/xml/cd-catalog.xml"));
	}
}
