package splitjvm.char11;

/**
 * @author yangll
 *
 * 垃圾回收
 */
public class GarbageCollectionTest {

    static double sum = 0;

    public static void foo() {
        for (int i = 0; i < 0x77777777; i++) {
            sum += Math.sqrt(i);
        }
    }

    public static void bar() {
        for (int i = 0; i < 50_000_000; i++) {
            new Object().hashCode();
        }
    }

    public static void main(String[] args) {
        new Thread(GarbageCollectionTest::foo).start();
        new Thread(GarbageCollectionTest::bar).start();
    }


}
