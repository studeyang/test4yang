package inputStreamRead;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReadTest {

    @Test
    public void test_read() throws IOException {
        File file = new File("src/main/resources/12pages.pdf");
        long size = FileUtils.sizeOf(file);
        System.out.println(size);

        InputStream inputStream = new FileInputStream(file);
        System.out.println(inputStream.available());
        byte[] buf = new byte[1024];
        long read = 0;
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            if (len != 1024) {
                System.out.println(len);
            }
            read += len;
        }
        System.out.println(read);

    }

}
