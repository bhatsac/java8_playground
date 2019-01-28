package com.bhatsac.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
/**
 * 
 * @author bhatsac
 *
 *reference : https://stackify.com/streams-guide-java-8/
 *
 */

public class _8_AdvancedCollect {
	
	// This is the code snippet which creates setup for analyzing features of java8
	 private static Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
		    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	
	public static void main(String[] args) {
		//Advanced collect
		//We already saw how we used Collectors.toList() to get the list out of the stream.
		//Let’s now see few more ways to collect elements from the stream.
		
		//1. joining
			joining();
		
		//2. toSet
			setDemo();
		
		//3. toCollection
			toCollectionDemo();
			
		//4. summarizingDouble
			summarizingDouble();
			
		//5. partitioningBy
			partitioningByDemo();
		 
		//6. groupingBy
			groupingByDemo();
			
		//7. reducing
			reducing();
		//8. grouping and reducing	
			groupingAndReducingDemo();
			    
	}


	private static void groupingAndReducingDemo() {
		Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);
		
		Map<Character, Optional<Employee>> longestNameByAlphabet = empList.stream().collect(
		  Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
		    Collectors.reducing(BinaryOperator.maxBy(byNameLength))));
		System.out.println(longestNameByAlphabet);
	}


	private static void reducing() {
		Double percentage = 10.0;
		Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
		    0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));
		System.out.println(salIncrOverhead);
	}


	private static void groupingByDemo() {
		//groupingBy() offers advanced partitioning – where we can partition the stream into more than just two groups.

		//It takes a classification function as its parameter. This classification function is applied to each element of the stream.

		//The value returned by the function is used as a key to the map that we get from the groupingBy collector:

		 Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
			      Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));
		 System.out.println(groupByAlphabet);
		//In this quick example, we grouped the employees based on the initial character of their first name. 
	}


	private static void partitioningByDemo() {
		//partitioningBy
		//We can partition a stream into two – based on whether the elements satisfy certain criteria or not.

		//Let’s split our List of numerical data, into even and odds:
		List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
		Map<Boolean, List<Integer>> isEven = intList.stream().collect(
		  Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println(isEven);
	}


	private static void summarizingDouble() {
		//summarizingDouble() is another interesting collector – which applies a double-producing mapping function to each input element 
		//and returns a special class containing statistical information for the resulting values:
		  DoubleSummaryStatistics stats = empList.stream()
			      .collect(Collectors.summarizingDouble(Employee::getSalary));
		  System.out.println(stats.getSum());
		  System.out.println(stats.getAverage());
		  System.out.println(stats.getMax());
		  System.out.println(stats.getMin());
		//Notice how we can analyze the salary of each employee and get statistical information on that data – such as min, max, average etc.
         //summaryStatistics() can be used to generate similar result when we’re using one of the specialized streams:
		  
		  DoubleSummaryStatistics stats2 = empList.stream()
			      .mapToDouble(Employee::getSalary)
			      .summaryStatistics();

			    System.out.println(stats.getCount());
			    System.out.println(stats.getSum());
	}


	private static void toCollectionDemo() {
		Vector<String> empNames = empList.stream()
		            .map(Employee::getName)
		            .collect(Collectors.toCollection(Vector::new));
		 System.out.println(empNames);
	}


	private static void setDemo() {
		Set<String> empNames = empList.stream()
	            .map(Employee::getName)
	            .collect(Collectors.toSet());
		System.out.println(empNames);
	}


	private static void joining() {
		//Collectors.joining() will insert the delimiter between the two String elements of the stream. 
		//It internally uses a java.util.StringJoiner to perform the joining operation.
		String empNames = empList.stream()
			      .map(Employee::getName)
			      .collect(Collectors.joining(", "))
			      .toString();
		System.out.println(empNames);
	}



	

}


