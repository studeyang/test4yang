package expire;

import org.junit.Before;
import org.junit.Test;

public class LruCacheTest {

    LruCache<String, Integer> cache;

    @Before
    public void before() {
        cache = new LruCache<>(4);
    }

    @Test
    public void test_lru() {
        cache.put("1", 1);
        cache.put("2", 2);
        cache.put("3", 3);
        cache.put("4", 4);
//        cache.put("5", 5);
//        cache.put("6", 6);
//        cache.put("7", 7);
        System.out.println(cache.get("3"));
        System.out.println(cache);
    }

}