package Asc;

import java.util.HashMap;

class DateClass {
    private int date;
    private int month;
    private int year;
   
    public DateClass(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }
   
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateClass)) {
            return false;
        }
        DateClass other = (DateClass) obj;
        return this.date == other.date && this.month == other.month;
    }
   
    @Override
    public int hashCode() {
        return 31 * date + month;
    }
}

public class Assignment3Q4 {

    public String getEmployee(HashMap<DateClass, String> dob, String employeeName) {
        for (DateClass date : dob.keySet()) {
            if (dob.get(date).equals(employeeName)) {
                return dob.get(date);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<DateClass, String> dob = new HashMap<>();
        dob.put(new DateClass(1, 1, 2000), "John");
        dob.put(new DateClass(2, 1, 2000), "Jane");
        dob.put(new DateClass(1, 2, 2001), "Mike");
        dob.put(new DateClass(1, 1, 2001), "Alice");
        dob.put(new DateClass(2, 1, 2001), "Bob");

        // Get employee with same day and month of birth but different birth year (should fail)
        String employee = new Assignment3Q4().getEmployee(dob, "Alice");
        System.out.println(employee);  

        // Get employee with unique date of birth (should succeed)
        employee = new Assignment3Q4().getEmployee(dob, "Mike");
        System.out.println(employee); 
        
        employee = new Assignment3Q4().getEmployee(dob, "Bob");
        System.out.println(employee); 
    }
}