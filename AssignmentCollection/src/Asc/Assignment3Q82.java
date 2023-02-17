package Asc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Assignment3Q82 {
    public static void failSafe(CopyOnWriteArrayList<Integer> list) {
        // Get the iterator
        Iterator<Integer> iterator = list.iterator();
        
        // Iterate over the list while checking for any structural modification
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            System.out.println("Item: " + item);
            // Adding an item to the list during iteration
            list.add(100);
        }
    }

    public static void main(String args[]) {
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        
        // Call the failSafe method
        failSafe(list);
    }
}
