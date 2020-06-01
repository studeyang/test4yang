package splitjvm.char07;

import java.lang.reflect.Method;

/**
 * @author yangll
 *
 * 探索JVM如何执行反射，基础版本
 */
public class ReflectionBase {

    public static void target(int i) {

    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("splitjvm.char07.ReflectionBase");
        Method method = clazz.getMethod("target", int.class);
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 100_000_000; i++) {
            method.invoke(null, 128);
        }
        long temp = System.currentTimeMillis();
        System.out.println(temp - current);
    }

}
