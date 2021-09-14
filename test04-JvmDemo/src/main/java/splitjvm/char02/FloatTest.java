package splitjvm.char02;

import org.junit.Test;

/**
 * @author yangll
 *
 * 测一下float类型
 */
public class FloatTest {

    @Test
    public void test_float() {
        System.out.println(Float.intBitsToFloat(0x7f800000));
        System.out.println(Float.intBitsToFloat(0x80000000));
        System.out.println(Float.intBitsToFloat(0xff800000));
    }

}
