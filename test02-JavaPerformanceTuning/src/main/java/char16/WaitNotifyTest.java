/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package char16;

import java.util.Vector;

/**
 * 通过 wait() / notify() 来实现一个简单的生产者和消费者的案例
 *
 * @author yangll
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        Vector<Integer> pool = new Vector<>();
        Producer producer = new Producer(pool, 10);
        Consumer consumer = new Consumer(pool);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

/**
 * 生产者
 *
 * @author admin
 */
class Producer implements Runnable {
    private Vector<Integer> pool;
    private Integer size;

    public Producer(Vector<Integer> pool, Integer size) {
        this.pool = pool;
        this.size = size;
    }

    public void run() {
        for (; ; ) {
            try {
                System.out.println(" 生产一个商品 ");
                produce(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        while (pool.size() == size) {
            synchronized (pool) {
                System.out.println(" 生产者等待消费者消费商品, 当前商品数量为 " + pool.size());
                pool.wait();// 等待消费者消费
            }
        }
        synchronized (pool) {
            pool.add(i);
            pool.notifyAll();// 生产成功，通知消费者消费
        }
    }
}


/**
 * 消费者
 *
 * @author admin
 */
class Consumer implements Runnable {
    private Vector<Integer> pool;

    public Consumer(Vector<Integer> pool) {
        this.pool = pool;
    }

    public void run() {
        for (; ; ) {
            try {
                System.out.println(" 消费一个商品 ");
                consume();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        while (pool.isEmpty()) {
            synchronized (pool) {
                System.out.println(" 消费者等待生产者生产商品, 当前商品数量为 " + pool.size());
                pool.wait();// 等待生产者生产商品
            }
        }
        synchronized (pool) {
            pool.remove(0);
            pool.notifyAll();// 通知生产者生产商品

        }
    }

}
