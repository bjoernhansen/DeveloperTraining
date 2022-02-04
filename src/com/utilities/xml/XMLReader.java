package com.utilities.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLReader
{
	public static void main(String[] args)
	{
		readXML();
	}
	
    private static void readXML()
    {
        SAXBuilder builder = new SAXBuilder();
        try
        {
            Document doc = builder.build(new File("src/com/utilities/xml/cd-catalog.xml"));
			// cd-catalog.xml
            Element menuBarElement = doc.getRootElement(); //<menubar>
            System.out.println(menuBarElement.getName()); //menubar>
            
            List<Element> menuElemente = menuBarElement.getChildren();
            for (Element menuElement : menuElemente)
            {
                System.out.println("\t" + menuElement.getChildText("TITLE")); //menu
                String attributeValue = menuElement.getAttributeValue("name");
                System.out.println("\t" + attributeValue);
                
                List<Element> menuItemElemente = menuElement.getChildren();
                for (Element menuItemElement : menuItemElemente)
                {
                    String elementName = menuItemElement.getName();
                    String itemText = menuItemElement.getTextTrim();
                    System.out.println("\t\t" + elementName + ": " + itemText);
                }
            }
        } catch (JDOMException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
