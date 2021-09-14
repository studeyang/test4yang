package splitjvm.char02;

import org.junit.Test;

/**
 * @author yangll
 *
 * 测试一下接口的继承
 */
public class InterfaceTest {

    private class InterfaceImpl implements Interface1, Interface2 {
        @Override
        public void doSth() {

        }
    }

    private interface Interface1 {
        void doSth();
    }

    private interface Interface2 {
        void doSth();
    }

    private static class StaticInterface {
        public static void doSth() {

        }
    }

    private static class SubStaticInterface extends StaticInterface {

    }

    @Test
    public void t_static() {
        SubStaticInterface.doSth();
    }


}
