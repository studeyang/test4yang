package leetcode;

import java.util.HashMap;

public class FindRepeatNumber {

    // Main method
    public static void main(String[] args) {

        // crete a HashMap and add some values
        HashMap<String, Integer> map = new HashMap<>(4);
        map.put("key1", 10000);
        map.put("key2", 55000);
        map.put("key3", 44300);
        map.put("key4", 53200);

        // print map details
        System.out.println("HashMap:\n " + map.toString());

        // provide value for new key which is absent
        // using computeIfAbsent method
        map.computeIfAbsent("key5", k -> 2000 + 33000);
        map.computeIfAbsent("key6", k -> 2000 * 34);

        // print new mapping
        System.out.println("New HashMap:\n " + map);
    }

}
