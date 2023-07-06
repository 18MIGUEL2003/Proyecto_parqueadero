package proyectoparqueadero;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Clase que crea un archivo PDF básico utilizando la biblioteca iText.
 */
public class pdf {

    public static void main(String[] args) {
        String dest = "pdf/hola_mundo.pdf";
        try {
            // Crear un documento
            Document document = new Document();
            
            // Establecer el escritor del documento para escribir en el archivo de destino
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();

            // Crear un párrafo con el contenido "Hola mundo" y agregarlo al documento
            Paragraph paragraph = new Paragraph("Hola mundo");
            document.add(paragraph);

            // Cerrar el documento
            document.close();
            
            System.out.println("PDF creado correctamente");
        } catch (DocumentException e) {
            // Manejar excepción en caso de error al trabajar con el documento
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // Manejar excepción en caso de error al abrir o crear el archivo PDF
            e.printStackTrace();
        }
    }
}
