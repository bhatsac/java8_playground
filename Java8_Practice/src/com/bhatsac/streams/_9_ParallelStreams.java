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
import java.util.stream.Stream;
/**
 * 
 * @author bhatsac
 *
 *reference : https://stackify.com/streams-guide-java-8/
 *
 */

public class _9_ParallelStreams {
	
	// This is the code snippet which creates setup for analyzing features of java8
	 private static Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0),
		        new Employee(4, "Lakshmi Mittal", 400000.0),
		        new Employee(5, "Mukesh Ambani", 400500.0),
		        new Employee(6, "Ratan Tata", 100000.0)
		    };

		    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
		    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	
	public static void main(String[] args) {
		//1. parallel
		   parallelDemo();
		//2. Infinite
		   infiniteDemo();
		//3. iterate  
		   iterateDemo();
	}


	private static void iterateDemo() {
		//iterate() takes two parameters: an initial value, called seed element and a function which generates next element using the previous value.
		  // iterate(), by design, is stateful and hence may not be useful in parallel streams:
		   
		   Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);	
		   //System.out.println(evenNumStream.collect(Collectors.toList())); // heap memory error
		   List<Integer> collect = evenNumStream
				      .limit(7)
				      .collect(Collectors.toList());
		   System.out.println(collect);
	}


	private static void infiniteDemo() {
		Stream.generate(Math::random)
		      .limit(5)
		      .forEach(System.out::println);
	}


	private static void parallelDemo() {
		//Using the support for parallel streams, we can perform stream operations in parallel without having to write any boilerplate code; we just have to designate the stream as parallel:
		   // refer out put to see how this works in parallel.
		   empList.stream().parallel().forEach(e -> e.incrementSalary(10.0));
		   System.out.println(empList);
	}


	


	

}


