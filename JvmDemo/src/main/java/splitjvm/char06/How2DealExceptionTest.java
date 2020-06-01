package splitjvm.char06;

/**
 * @author yangll
 *
 * 探索JVM如何处理异常
 */
public class How2DealExceptionTest {

    public static void main(String[] args) {
        try {
            mayThrowException();
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void mayThrowException() {

    }

}
