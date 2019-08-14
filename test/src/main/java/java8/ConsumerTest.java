package java8;

import java.util.function.Consumer;

/**
 * @author yangll
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> consumer = string -> System.out.println(string);

        consumer.accept("test");
    }


}
