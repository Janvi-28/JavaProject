package Asc;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Assignment3Q2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        System.out.println("HashSet: " + unordered(hashSet));

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        System.out.println("LinkedHashSet: " + ordered(linkedHashSet));
    }

    public static HashSet unordered(HashSet hashSet) {
        return hashSet;
    }

    public static LinkedHashSet ordered(LinkedHashSet linkedHashSet) {
        return linkedHashSet;
    }
}


