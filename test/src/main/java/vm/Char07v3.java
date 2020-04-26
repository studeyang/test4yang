package vm;

import java.lang.reflect.Method;

public class Char07v3 {

    public static void target(int i) {

    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("vm.Char07v3");
        Method method = clazz.getMethod("target", int.class);

        Object[] arg = new Object[1];
        arg[0] = 128;

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, arg);
        }
    }

}
