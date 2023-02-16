package training.utilities.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfMaker
{
    public static void main(String[] args) {
        try {
            
            String outfile = "logs/my.pdf";
            
            PDDocument doc = new PDDocument();
            PDPage page1 = new PDPage();
            doc.addPage(page1);
            
            PDPageContentStream content = new PDPageContentStream(doc, page1);
            
            content.beginText();
            content.setFont( PDType1Font.HELVETICA_BOLD, 18 );
            content.newLineAtOffset( 100, 700 );
            content.showText( "Hallo PDF  Welt" );
            content.endText();
            content.close();
            doc.save(outfile);
            doc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

