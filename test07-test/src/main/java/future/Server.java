package future;

import java.util.concurrent.CompletableFuture;

public class Server {

    public CompletableFuture call(String request) {
        System.out.println("i am server. i received a request: " + request);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("server processing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "success";
        });
//        new Thread(() -> {
//            if (isDone[0]) {
                future.complete("success when processing");
//            }
//        }).start();
        return future;
    }


}
