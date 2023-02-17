package Asc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Assignment3Q81 {
    public static void failFast(Map<String, String> cityCode) {
        final Iterator<Map.Entry<String, String>> iterator = cityCode.entrySet().iterator();

        // Creating a new thread to modify the Map while iterating
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                cityCode.put("4", "New York");
            }
        });
        thread.start();

        // Iterating through the Map
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> cityCode = new HashMap<>();
        cityCode.put("1", "London");
        cityCode.put("2", "Paris");
        cityCode.put("3", "Tokyo");
        failFast(cityCode);
    }
}


