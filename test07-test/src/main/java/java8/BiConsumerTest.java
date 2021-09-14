package java8;

import java.util.function.BiConsumer;

/**
 * @author yiibai
 */
public class BiConsumerTest {

    public static void main(String[] args) {
        BiConsumer<Integer, String> consumer = (a, b) -> System.out.println(a + b);

        consumer.accept(5, "Chapters");
    }


}
