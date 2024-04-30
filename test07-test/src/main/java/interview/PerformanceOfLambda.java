package interview;

import java.util.ArrayList;
import java.util.List;

public class PerformanceOfLambda {

    private List<Integer> integers;

    public PerformanceOfLambda() {
        integers = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            integers.add(4);
            integers.add(5);
            integers.add(7);
            integers.add(9);
        }
    }

    public static void main(String[] args) {
        PerformanceOfLambda performanceOfLambda = new PerformanceOfLambda();
        long time1 = System.currentTimeMillis();
        int lambdaMaxInteger = performanceOfLambda.lambdaMaxInteger();
        long time2 = System.currentTimeMillis();
        int forEachMaxInteger = performanceOfLambda.forEachLoopMaxInteger();
        System.out.println(String.format("lambdaMaxInteger : %s, cost time %sms", lambdaMaxInteger, time2 - time1));
        System.out.println(String.format("forEachMaxInteger : %s, cost time %sms", forEachMaxInteger, System.currentTimeMillis() - time2));
    }

    private int lambdaMaxInteger() {
        return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }

    private int forEachLoopMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Integer integer : integers) {
            max = Integer.max(max, integer);
        }
        return max;
    }

}
