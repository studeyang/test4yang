package pdf2word;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pdf2word {

    public static void main(String[] args) {

        try {
            String pdfFileName = "D:/test/pdf2word/1.pdf";
            PDDocument pdf = PDDocument.load(new File(pdfFileName));
            int pageNumber = pdf.getNumberOfPages();

            String docFileName = pdfFileName.substring(0, pdfFileName.lastIndexOf(".")) + ".doc";

            File file = new File(docFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            CustomXWPFDocument document = new CustomXWPFDocument();
            FileOutputStream fos = new FileOutputStream(docFileName);

            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pageNumber);
            //当前页中的文字
            String text = stripper.getText(pdf);

            XWPFParagraph textParagraph = document.createParagraph();
            XWPFRun textRun = textParagraph.createRun();
            textRun.setText(text);
            textRun.setFontFamily("仿宋");
            textRun.setFontSize(11);
            //换行
            textParagraph.setWordWrap(true);

            document.write(fos);
            fos.close();
            pdf.close();
            System.out.println("pdf转换解析结束！！----");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
