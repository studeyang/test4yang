package char01;

/**
 * @author yangll
 */
public class VolatileExample {
    private int x = 0;
    private volatile boolean v = false;
    private void writer() {
        x = 42;
        v = true;
    }
    private void reader() {
        if (v) {
            // 这里 x 会是多少呢？
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        new Thread(() -> example.writer()).start();
        new Thread(() -> example.reader()).start();
    }
}
