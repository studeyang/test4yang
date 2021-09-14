package inputStreamRead;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端：读取流数据测试
 *
 * @author yangll
 * @date 20190904
 */
public class Client {

    /**
     * 文件的大小
     */
    static int FILESIZE = 139407;

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 8888);
        OutputStream os = s.getOutputStream();
        InputStream is = Client.class.getResourceAsStream("/inputStream/12pages.pdf");
        byte[] b = new byte[FILESIZE];
        int i = is.read(b);
        is.close();
        os.write(b, 0, i);
        os.flush();
        os.close();
        s.close();
    }


}
