package bio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        StringBuilder read = new StringBuilder();
        while (bufferedInputStream.read(buf) != -1) {
            read.append(new String(buf));
        }
        System.out.println(read.toString());
    }

}
