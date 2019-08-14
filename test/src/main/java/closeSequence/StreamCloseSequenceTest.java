package closeSequence;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class StreamCloseSequenceTest {

    private PdfReader pdfReader;
    private String resultPath;

    @Before
    public void before() throws IOException {
        // 生成结果路径
        resultPath = "D://test/testStreamCloseSequence/";
        // 初始化 pdfReader
        File file = new File(StreamCloseSequenceTest.class.getResource("").getPath() + "12pages.pdf");
        pdfReader = new PdfReader(new FileInputStream(file));
    }

    /**
     * 正常运行
     * @throws IOException 异常
     */
    @Test
    public void test_nomal() throws IOException {
        for (int page = 1; page < pdfReader.getNumberOfPages() + 1; page++) {
            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            String name = "split-" + page + ".pdf";
            File tempFile = FileUtils.getFile(resultPath, name);
            FileUtils.forceMkdirParent(tempFile);
            OutputStream outputStream = null;
            PdfWriter writer = null;
            // 这里对于outputStream不能使用try-with-resources，流的关闭顺序不能变
            try {
                outputStream = new FileOutputStream(tempFile);
                writer = PdfWriter.getInstance(document, outputStream);
                document.open();
                PdfImportedPage pdfImportedPage = writer.getImportedPage(pdfReader, page);
                Image image = Image.getInstance(pdfImportedPage);
                float scale = PageSize.A4.getWidth() / image.getWidth();
                image.scalePercent(scale * 100);
                document.add(image);
            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            } finally {
                // 关闭的顺序不能调整
                document.close();
                writer.close();
                outputStream.close();
            }
        }
    }

    /**
     * 抛出异常
     * @throws IOException 异常
     */
    @Test
    public void test_useTryWithResource() throws IOException {
        for (int page = 1; page < pdfReader.getNumberOfPages() + 1; page++) {
            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            String name = "split-" + page + ".pdf";
            File tempFile = FileUtils.getFile(resultPath, name);
            FileUtils.forceMkdirParent(tempFile);
            PdfWriter writer = null;
            // 这里对于outputStream不能使用try-with-resources，流的关闭顺序不能变
            try(OutputStream outputStream = new FileOutputStream(tempFile)) {
                writer = PdfWriter.getInstance(document, outputStream);
                document.open();
                PdfImportedPage pdfImportedPage = writer.getImportedPage(pdfReader, page);
                Image image = Image.getInstance(pdfImportedPage);
                float scale = PageSize.A4.getWidth() / image.getWidth();
                image.scalePercent(scale * 100);
                document.add(image);
            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            } finally {
                // 关闭的顺序不能调整
                document.close();
                writer.close();
            }
        }
    }

}
