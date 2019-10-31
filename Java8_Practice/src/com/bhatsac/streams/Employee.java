package com.bhatsac.streams;
public class Employee implements Comparable<Employee>{

	int id;
	String name;
	Double salary;
	
	
	
	public Employee(int id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int compareTo(Employee o) {
		
		return this.id;
	}
	
	public void incrementSalary(double sal){
		// refer _9_ParallelStreams
		System.out.println("This is to test the parallel-check for :"+ Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.salary=+sal;
		System.out.println("This is to test the parallel-check ends:"+ Thread.currentThread().getName());
	}
}