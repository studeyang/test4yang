package shutdownhook;

public class ShutdownHookTest {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am hook");
        }));
        for (int i = 0; i < 10; i++){
            Thread.sleep(1000);
            System.out.println("live");
        }
    }

}
