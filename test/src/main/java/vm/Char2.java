package vm;

import org.junit.Test;

public class Char2 {

    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            System.out.println("Hello, Java");
        }
        if (true == flag) {
            System.out.println("Hello, Jvm");
        }
    }

    @Test
    public void test_float() {
        System.out.println(Float.intBitsToFloat(0x7f800000));
        System.out.println(Float.intBitsToFloat(0x80000000));
        System.out.println(Float.intBitsToFloat(0xff800000));
    }

    @Test
    public void test_eq() {
        System.out.println("tt".equals(null));
    }

    @Test
    public void test_over() {
        over(1);
    }

    public void over(int i) {
        System.out.println("int");
    }

    public void over(Integer i) {
        System.out.println("Integer");
    }

    private class F implements T, D {
        @Override
        public void t() {

        }
    }

    private interface T {
        public void t();
    }

    private interface D {
        public void t();
    }

    private static class Q {
        public static void q() {

        }
    }

    private static class W extends Q {

    }

    @Test
    public void t_static() {
        W.q();
    }


}
