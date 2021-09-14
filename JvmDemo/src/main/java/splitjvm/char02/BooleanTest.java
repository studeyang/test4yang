package splitjvm.char02;

/**
 * @author yangll
 *
 * 测试一下if的2种情况
 */
public class BooleanTest {

    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            System.out.println("Hello, Java");
        }
        if (true == flag) {
            System.out.println("Hello, Jvm");
        }
    }

}
