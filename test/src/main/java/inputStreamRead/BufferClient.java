package inputStreamRead;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BufferClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8889);
        OutputStream os = socket.getOutputStream();
        InputStream is = BufferClient.class.getResourceAsStream("/inputStreamRead/12pages.pdf");
        byte[] b = new byte[1000];
        int read;
        while ((read = is.read(b)) != -1) {
            os.write(b, 0, read);
        }
        is.close();
        os.flush();
        os.close();
        socket.close();
    }


}
