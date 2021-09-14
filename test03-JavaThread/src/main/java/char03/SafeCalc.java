package char03;

public class SafeCalc {
    long value = 0L;
    synchronized long get() {
        System.out.println(Thread.currentThread().getName() + " read");
        return value;
    }
    synchronized void addOne() {
        value += 1;
        System.out.println(Thread.currentThread().getName() + " write");
    }

    public static void main(String[] args) throws InterruptedException {
        SafeCalc safeCalc = new SafeCalc();
        new Thread(() -> safeCalc.addOne()).start();
        new Thread(() -> safeCalc.addOne()).start();
        new Thread(() -> System.out.println("value : " + safeCalc.get())).start();
    }

}
