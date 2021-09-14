package char01;

/**
 * @author yangll
 */
public class VisibleTest {
    private volatile long count = 0;

    private void add(int number) {
        int idx = 0;
        while (idx++ < number) {
            set(get() + 1);
        }
    }

    private synchronized void set(long v) {
        count = v;
    }

    private synchronized long get() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        VisibleTest test = new VisibleTest();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> test.add(100_000_000));
        Thread th2 = new Thread(() -> test.add(100_000_000));
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        // 执行的结果一直是200_000_000, 应该是这几个线程都绑定到了同一个cpu上
        System.out.println(test.get());
    }

}
