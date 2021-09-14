package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Server server = new Server();
        CompletableFuture future = server.call("123");
        System.out.println(future.get());
    }

}
