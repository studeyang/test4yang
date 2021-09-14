package html2word;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Pdf2word {

    public static void convert(String pdffile, String docFile) throws Exception {
        PDDocument doc =  PDDocument.load(new File(pdffile));
        //获取总页数
        int pagenumber = doc.getNumberOfPages();
        FileOutputStream fos = new FileOutputStream(docFile);
        Writer writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        PDFTextStripper stripper = new PDFTextStripper();
        //排序
        stripper.setSortByPosition(true);
        //设置转换的开始页
        stripper.setStartPage(1);
        //设置转换的结束页
        stripper.setEndPage(pagenumber);
        stripper.writeText(doc, writer);
        writer.close();
        doc.close();
    }

}
