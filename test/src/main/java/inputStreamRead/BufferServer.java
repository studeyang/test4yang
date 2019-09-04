package inputStreamRead;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端：读取流数据测试
 *
 * @author yangll
 * @date 20190904
 */
public class BufferServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8889);
        System.out.println("runing");
        while (true) {
            byte[] b = new byte[1024];
            int readBytes = 0;
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            File file = new File(BufferServer.class.getResource("").getPath() + "copy.pdf");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("creat " + file.toString());
            }
            FileOutputStream fos = new FileOutputStream(file);
            int read;
            while ((read = is.read(b)) != -1) {
                System.out.println(read);
//                fos.write(b, 0, read);
                /* 不能这么写。
                fos.write(b); 相当于 fos.write(b, 0, b.length);
                read 有可能小于 b.length */
                fos.write(b);
                readBytes += read;
            }
            fos.flush();
            fos.close();
            System.out.println("complete : " + readBytes);
            is.close();
            socket.close();
        }
    }

}

