package html2word;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

public class SpirePdf2word {

    public static void convert(String pdfFile, String docFile) {
        PdfDocument pdf = new PdfDocument(pdfFile);
        pdf.saveToFile(docFile, FileFormat.DOC);
    }

}
