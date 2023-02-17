package Asc;
import java.util.HashMap;

class Employee {
	
	private String name;
	private int id;
	private int hash;
	public Employee(String name, int id, int hash) {
		this.name = name;
		this.id = id;
		this.hash = hash;	
	}

	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return hash;
	}
	
}



public class Assignment3Q5 {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee("Anandi Sharma", 101, 150);
		Employee employee2 = new Employee("Aditi Verma", 102, 200);
		Employee employee3 = new Employee("Kritika Yadav", 103, 250);
		Employee employee4 = new Employee("Shivangi Patel", 104, 300);
		
		HashMap<Integer, Employee> map = new HashMap<>();
		map.put(employee1.getId(), employee1);
		map.put(employee2.getId(), employee2);
		map.put(employee3.getId(), employee3);
		map.put(employee4.getId(), employee4);
		
		System.out.println("Lets find the bucket for employee3 with hashCode " + employee2.hashCode());
		Integer bucket = employee2.hashCode();
		for(int id: map.keySet()) {
			if((map.get(id).hashCode()) == bucket) {
				System.out.println("Found the matching bucket Employee with Id: " + map.get(id).getId() + "  Name: " + map.get(id).getName());
			}
		}
		
	}

}

