package training.utilities.xml.cd_tree;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javafx.scene.control.TreeItem;


class CDTreeCreator
{	
	public static TreeItem<String> createTree(String documentPath) 
	{		
		SAXBuilder builder = new SAXBuilder();
		TreeItem<String> rootItem = null;
		
		try 
		{
			Document doc = builder.build(new File(documentPath));
			Element menuBarElement = doc.getRootElement();				
			rootItem = new TreeItem<>(menuBarElement.getName());
									
			List<Element> menuElemente = menuBarElement.getChildren();				
			for (Element menuElement : menuElemente)
			{
				TreeItem<String> tempSuperTreeItem = new TreeItem<>(menuElement.getChildText("TITLE"));
				rootItem.getChildren().add(tempSuperTreeItem);
				
				List<Element> menuItemElemente = menuElement.getChildren();
				for (Element menuItemElement : menuItemElemente) 
				{										
					String elementName 	= menuItemElement.getName();
					String itemText 	= menuItemElement.getTextTrim();	
					
					TreeItem<String> tempTreeItem = new TreeItem<>(elementName +  ": " + itemText);
					
					tempSuperTreeItem.getChildren().add(tempTreeItem);					
				}
			}			
			rootItem.setExpanded(true);		
		} 
		catch (JDOMException | IOException e) 
		{
			e.printStackTrace();			
		}
		return rootItem;
	}
}
