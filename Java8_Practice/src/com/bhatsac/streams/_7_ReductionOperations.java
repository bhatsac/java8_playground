package com.bhatsac.streams;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
/**
 * 
 * @author bhatsac
 *
 *reference : https://stackify.com/streams-guide-java-8/
 *
 */

public class _7_ReductionOperations {
	
	// This is the code snippet which creates setup for analyzing features of java8
	 private static Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
		    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	
	public static void main(String[] args) {
		
		//1. reduce
		reduceDemo();
	}


	private static void reduceDemo() {
		
		
		//The most common form of reduce() is:

		//	T reduce(T identity, BinaryOperator<T> accumulator)
		//	where identity is the starting value and accumulator is the binary operation we repeated apply.
		
		 Double sumSal = empList.stream()
			      .map(Employee::getSalary)
			      .reduce(0.0, Double::sum);
		 System.out.println(sumSal);
		//Here, we start with the initial value of 0 and repeated apply Double::sum() on elements of the stream. Effectively we’ve implemented the DoubleStream.sum() by applying reduce() on Stream.	   
	}



	

}


