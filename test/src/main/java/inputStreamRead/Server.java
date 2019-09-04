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
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("runing");
        while (true) {
            byte[] b = new byte[Client.FILESIZE];
            int readBytes = 0;
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            while (readBytes < Client.FILESIZE) {
                int read = is.read(b, readBytes, Client.FILESIZE - readBytes);
                System.out.println(read);
                if (read == -1) {
                    break;
                }
                readBytes += read;
            }
            File file = new File(Server.class.getResource("").getPath() + "copy.pdf");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("creat " + file.toString());
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(b, 0, readBytes);
            fos.flush();
            fos.close();
            System.out.println("complete");
            is.close();
            socket.close();
        }
    }

}

