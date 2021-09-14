package splitjvm.char02;

import org.junit.Test;

/**
 * @author yangll
 *
 * 测试一下同一方法基本类型参数与包装类型参数调用的优先顺序
 */
public class OverrideTest {

    @Test
    public void test_over() {
        over(1);
    }

    private void over(int i) {
        System.out.println("int");
    }

    private void over(Integer i) {
        System.out.println("Integer");
    }

}
