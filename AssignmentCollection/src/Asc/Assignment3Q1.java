package Asc;

import java.util.TreeSet;

class Person implements Comparable<Person> {
    private String name;
    private int height;
    private double weight;

    public Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Person other) {
        int weightCompare = Double.compare(this.weight, other.weight);
        if (weightCompare != 0) {
            return weightCompare;
        } else {
            return Integer.compare(this.height, other.height);
        }
    }

    @Override
    public String toString() {
        return name + " (" + weight + "kg, " + height + "cm)";
    }
}

public class Assignment3Q1 {
    public static void main(String[] args) {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("John" , 170, 75.0));
        people.add(new Person("Jane" , 160, 60.0));
        people.add(new Person("Jim" , 180, 75.0));
        people.add(new Person("Sarah", 165, 55.0));
        people.add(new Person("Tom" , 175, 80.0));
        System.out.println(people);
    }
}


