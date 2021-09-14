/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package char17;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁的升级问题
 *
 * @author yangll
 */
public class LevelUpLockDemo {

    final Map<String, String> cache = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock r = rwl.readLock();
    private Lock w = rwl.writeLock();

    public void read(String key) {
        // 读缓存
        r.lock();
        try {
            String v = cache.get(key);
            System.out.println("the value: " + v);
            if (v == null) {
                w.lock();
                try {
                    // 再次验证并更新缓存
                    // 省略详细代码
                    System.out.println("write lock is using.");
                } finally {
                    w.unlock();
                }
            }
        } finally {
            r.unlock();
        }
    }

    public static void main(String[] args) {
        LevelUpLockDemo demo = new LevelUpLockDemo();
        demo.init();
        // 读锁还没有释放，此时获取写锁，会导致写锁永久等待
        demo.read("0");
//        demo.read("1");
    }

    private void init() {
        cache.put("1", "aaa");
    }

}
