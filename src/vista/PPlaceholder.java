package vista;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PPlaceholder {

    public PPlaceholder(){
        //Create PDF and create page

        PDDocument document = new PDDocument();
        PDPage firstpage = new PDPage();
        document.addPage(firstpage);
        try {
            document.save(System.getProperty("user.home")+"/Desktop/sobra.pdf ");
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
// open pdf
        File oldfile = new File (System.getProperty("user.home")+"/Desktop/Guion Pornosotros__ Ladron, victima y descanso- .pdf");

        try {
            PDDocument document2 = Loader.loadPDF(oldfile);
            document2.addPage(new PDPage());
            document2.save(System.getProperty("user.home")+"/Desktop/new.pdf");
            document2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File oldfile2 = new File ("Plantilla2.pdf");

        try {
            PDDocument document3 = Loader.loadPDF(oldfile2);
            //PDDocument dagoat = new PDDocument();
            PDPage only = document3.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(document3,only);
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 18);
            contentStream.beginText();
            contentStream.setLeading(16.0f);

            //contentStream.newLineAtOffset(25, only.getCropBox().getHeight()-25);

            String text1 = "this is first line";
            String text2 = "this is second line";
            contentStream.showText(text1);
            contentStream.newLine();
            contentStream.showText(text2);

            contentStream.endText();
            contentStream.close();

            document3.save(System.getProperty("user.home")+"/Desktop/new2.pdf");
            document3.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        try {
            PDDocument doc = new PDDocument();
            PDImageXObject plant = PDImageXObject.createFromFile("media/Plantilla.png", doc);
            PDPage reporte = new PDPage();
            doc.addPage(reporte);
            PDPageContentStream contentStream = new PDPageContentStream(doc, reporte);
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 14);
            contentStream.drawImage(plant, 0, 0, reporte.getCropBox().getWidth(), reporte.getCropBox().getHeight());
            contentStream.beginText();
            contentStream.setLeading(16.0f);
            contentStream.newLineAtOffset(200, reporte.getCropBox().getHeight()-200);

            String text1 = "this is first line";
            String text2 = "this is second line";
            contentStream.showText(text1);
            contentStream.newLine();
            contentStream.showText(text2);

            contentStream.endText();
            contentStream.close();
            doc.save(System.getProperty("user.home")+"/Desktop/reporte.pdf");
            doc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }






}
