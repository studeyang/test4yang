package github.yang.disruptor;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueue4Test {

    public static void main(String[] args) {
        final ArrayBlockingQueue<LongEvent> queue = new ArrayBlockingQueue<>(100_000_000);
        final long startTime = System.currentTimeMillis();
        // 向容器中添加元素
        new Thread(() -> {
            long i = 0;
            while (i < 10_000_000) {
                try {
                    queue.put(new LongEvent(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }).start();
        // 从容器中取出元素
        new Thread(() -> {
            long k = 0;
            while (k < 10_000_000) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                k++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("ArrayBlockingQueue costTime = " + (endTime - startTime) + "ms");
        }).start();
    }
}