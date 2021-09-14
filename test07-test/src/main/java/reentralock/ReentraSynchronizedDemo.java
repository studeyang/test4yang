package reentralock;

public class ReentraSynchronizedDemo {

    private Object object = new Object();

    private void test() {
        synchronized (object) {
            synchronized (object) {
                System.out.println("yeah.");
            }
        }
    }

    public static void main(String[] args) {
        ReentraSynchronizedDemo demo = new ReentraSynchronizedDemo();
        demo.test();
    }

}
