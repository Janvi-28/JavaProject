package Asc;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Assignment3Q3 {
    public static List traverseReverse(ArrayList aList) {
        ListIterator<Object> listIterator = aList.listIterator(aList.size());
        ArrayList<Object> reversedList = new ArrayList<>();
        while (listIterator.hasPrevious()) {
            reversedList.add(listIterator.previous());
        }
        return reversedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println("ArrayList in reverse: " + traverseReverse(numbers));
    }
}


