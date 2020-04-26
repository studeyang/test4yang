package vm;

import java.lang.reflect.Method;

public class Char07base {

    public static void target(int i) {

    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("vm.Char07base");
        Method method = clazz.getMethod("target", int.class);
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 100_000_000; i++) {
            method.invoke(null, 128);
        }
        long temp = System.currentTimeMillis();
        System.out.println(temp - current);
    }

}
