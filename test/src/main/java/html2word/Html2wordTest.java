package html2word;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Html2wordTest {

    private String wordPath = "D:/test/html2word/";
    private String htmlPath = "D:/test/html2word/1.html";

    @Before
    public void before() {

    }

    @Test
    public void html2word_poi() throws Exception {
        String html = FileUtils.readFileToString(new File(htmlPath), "GBK");
        PoiHtml2word.htmlToWord("poi.doc", wordPath, html);
    }

    @Test
    public void html2word_jcob() throws IOException {
        String html = FileUtils.readFileToString(new File(htmlPath), "UTF-8");
        JcobHtml2word.getWord(html, wordPath, 6456);
    }

    @Test
    public void pdf2word_pdfbox() throws Exception {
        String pdfFile = "D:/test/1.pdf";
        String docFile = "D:/test/pdf2word.doc";
        Pdf2word.convert(pdfFile, docFile);
    }

    @Test
    public void pdf2word_spirePdf() {
        String pdfFile = "D:/test/卷皮/1.pdf";
        String docFile = "D:/test/卷皮/卷皮.doc";
        SpirePdf2word.convert(pdfFile, docFile);
    }

    @Test
    public void wkhtmltopdf() throws IOException, InterruptedException {
        String cmd = "wkhtmltopdf --margin-top 0 --margin-bottom 0 --margin-left 0 --margin-right 0 D:\\work\\4.5.3\\缺陷\\_origin.html D:\\work\\4.5.3\\缺陷\\_converted.pdf";
        int res = Runtime.getRuntime().exec(cmd).waitFor();
        System.out.println(res);
    }

}
