package com.bhatsac.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;
/**
 * 
 * @author bhatsac
 *
 *reference : https://stackify.com/streams-guide-java-8/
 *
 */
/**As we’ve been discussing, stream operations are divided into intermediate and terminal operations.

Intermediate operations such as filter() return a new stream on which further processing can be done. Terminal operations, such as forEach(), mark the stream as consumed, after which point it can no longer be used further.

A stream pipeline consists of a stream source, followed by zero or more intermediate operations, and a terminal operation.

Here’s a sample stream pipeline, where empList is the source, filter() is the intermediate operation and count is the terminal operation:
**/
public class _4_StreamsOperations {
	
	// This is the code snippet which creates setup for analyzing features of java8
	 private static Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
		    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	
	public static void main(String[] args) {
	//1. pipelineDemo
		pipeLineDemo();
	//2. short circuit demo	
		shortCircuitDemo();
	//3. Lazy Evaluation
		lazyEvaulationDemo();
			    
	}


	private static void lazyEvaulationDemo() {
		//One of the most important characteristics of streams is that they allow for significant optimizations through lazy evaluations.

		//Computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed.

		//All intermediate operations are lazy, so they’re not executed until a result of a processing is actually needed.
		 Integer[] empIds = { 1, 2, 3, 4 };
		 Employee employee = Stream.of(empIds)
			      .map(employeeRepository::findById)
			      .filter(e -> e != null)
			      .filter(e -> e.getSalary() > 200000)
			      .findFirst()
			      .orElse(null);
		 System.out.println(employee);
	}


	private static void shortCircuitDemo() {
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
		System.out.println(infiniteStream);
	    List<Integer> collect = infiniteStream
	      .skip(3)
	      .limit(5)
	      .collect(Collectors.toList());
	    System.out.println(collect);
	}


	private static void pipeLineDemo() {
		//A stream pipeline consists of a stream source, followed by zero or more intermediate operations, and a terminal operation.
		Long empCount = empList.stream()
			      .filter(e -> e.getSalary() > 200000)
			      .count();
	}

}


