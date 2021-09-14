package splitjvm.char07;

import java.lang.reflect.Method;

/**
 * @author yangll
 *
 * 探索JVM如何执行反射，V3版本
 */
public class ReflectionV3 {

    public static void target(int i) {

    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("splitjvm.char07.ReflectionV3");
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
