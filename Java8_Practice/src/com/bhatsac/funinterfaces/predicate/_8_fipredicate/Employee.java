package com.bhatsac.funinterfaces.predicate._8_fipredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Employee {

	String name;
	String designation;
	Double salary;
	String city;
	public Employee(String name, String designation, double salary, String city) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee e=(Employee)obj;
		//System.out.println(e.toString());
		
		
		//System.out.println(this.toString());
		
		
			if(name.equalsIgnoreCase(e.name)
			&& designation.equalsIgnoreCase(e.designation)
			&& city.equalsIgnoreCase(e.city)
			&& salary.equals(e.salary)
			){
				//System.out.println("I am here");
				return true;
				
			}
			else
			{ //System.out.println("I am here else");
				return false;
			}
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", designation=" + designation + ", salary=" + salary + ", city=" + city
				+ "]";
	}

	public static void main(String[] args) {
		List<Employee> empList= new ArrayList<Employee>();
		empList.add(new Employee("Sachin", "SE", 4343343, "Bangalore") );
		empList.add(new Employee("Kerthi", "CE", 4343343, "Bangalore") );
		empList.add(new Employee("Sudha", "HW", 4343343, "kumta") );
		empList.add(new Employee("Suresh", "BE", 4343343, "kumta") );
		
		Predicate<Employee> p1= e-> e.city.equalsIgnoreCase("bangalore");
		
		Predicate<Employee> p2= e-> e.salary>50000;
		
		Predicate<Employee> p3= e-> !e.name.isEmpty();
		
		Predicate<Employee> p4= e-> !e.designation.isEmpty();
		
		conditionCheck(p1.and(p2.and(p3.and(p4))),empList); // nested predicates check.
		
		System.out.println("Checking objects are equal!!!");
		// checking are equal
		Predicate<Employee> p = Predicate.isEqual(new Employee("Sachin", "SE", 4343343, "Bangalore"));
		System.out.println(p.test(new Employee("Sachin", "SE", 4343343, "Bangalore")));
		System.out.println(p.test(new Employee("Suresh", "BE", 4343343, "kumta") ));
		
		
	}
	
	public static void conditionCheck(Predicate<Employee> p, List<Employee> empList){
		for (Employee employee : empList) {
			System.out.println(p.test(employee));
		}
	}
	
}


