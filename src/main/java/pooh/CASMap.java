package pooh;

/**
 * Example functional of Stream collections class
 */

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentHashMap;

public class CASMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> queue = new ConcurrentHashMap<>();
        String name = "weather";
        queue.putIfAbsent(name, new ConcurrentLinkedQueue<>());
        queue.get(name).add("value");
        var text = queue.get(name).poll();
    }

    private static String emptyQueue() {
        return null;
    }


}
