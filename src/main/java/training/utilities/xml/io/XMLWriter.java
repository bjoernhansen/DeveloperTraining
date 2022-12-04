package training.utilities.xml.io;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLWriter 
{
	public static void main(String[] args)
	{
		System.out.println("Write xml ...");
		writeXML();
		
	}
	
	private static void writeXML()
	{		
		try 
		{
			Element rootElement = new Element("root");
			Document doc = new Document(rootElement);
			
			Element child1 = new Element("child1");
			Element child2 = new Element("child3");
			child1.setAttribute(new Attribute("id", "1234"));
			child1.setText("Max");
			child2.addContent(new Element("child2a"));
			
			rootElement.addContent(child1);
			rootElement.addContent(child2);
			
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
						
			FileOutputStream out = new FileOutputStream("logs/out.xml");
			
			outputter.output(doc, out);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
