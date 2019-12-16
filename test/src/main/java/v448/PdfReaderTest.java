package v448;

import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * @author lenovo
 */
public class PdfReaderTest {

    private static final String FILE_PATH = "/v448/1.pdf";

    public static void main(String[] args) throws Exception {
        System.out.println(getPdfReaderComplex().getNumberOfPages());
        System.out.println(getPdfReaderNomal().getNumberOfPages());
    }

    private static PdfReader getPdfReaderComplex() throws IOException, IllegalAccessException, NoSuchFieldException {
        InputStream inputStream = PdfReaderTest.class.getResourceAsStream(FILE_PATH);
        RandomAccessFileOrArray fileOrArray = new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(inputStream));
        PdfReader pdfReader = new PdfReader(fileOrArray, null, true);
        //打开pdf无需加密
        Field f = PdfReader.class.getDeclaredField("ownerPasswordUsed");
        f.setAccessible(true);
        f.set(pdfReader, Boolean.TRUE);
        return pdfReader;
    }

    private static PdfReader getPdfReaderNomal() throws IOException {
        InputStream inputStream = PdfReaderTest.class.getResourceAsStream(FILE_PATH);
        return new PdfReader(inputStream);
    }

}
