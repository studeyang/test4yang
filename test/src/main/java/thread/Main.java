package thread;

public class Main {

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ": alive");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(1 / 0);
            }
        }.start();

    }

}
