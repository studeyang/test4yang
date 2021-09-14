package string;

/**
 * 运行参数: -Xmx8g -Xms8g
 */
public class StringMaxLength {

    // 65534个a, 65535个a编译会报错
    private final static String latinString = "a...a";

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        // 最长为 Integer.MAX_VALUE - 8个
        for (int i = 0; i < Integer.MAX_VALUE - 8; i++) {
            builder.append("a");
        }
        System.out.println(builder.length());
    }

    /*
     * 问题：String最长可以分配多少个内存?
     * 结论：
     * 1. 如果是在编译时，最长为65534个
     * 2. 如果是在运行时，最长为Integer.MAX_VALUE - 8个
     * ArrayList 的 MAX_ARRAY_SIZE 字段作出了解释
     */

}
