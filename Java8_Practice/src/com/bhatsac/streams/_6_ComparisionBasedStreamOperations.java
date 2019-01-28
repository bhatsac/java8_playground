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

public class _6_ComparisionBasedStreamOperations {
	
	// This is the code snippet which creates setup for analyzing features of java8
	 private static Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
		    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	
	public static void main(String[] args) {
		//1. sorted
		 sortedDemo();
		
		 //2. min and max
		 minMaxDemo();
		 
		 //3. distinct
		 distinctDemo();
		 
		 //4. allMatch, anyMatch, and noneMatch
		 
		//allMatch() checks if the predicate is true for all the elements in the stream. Here, it returns false as soon as it encounters 5, which is not divisible by 2.

		//anyMatch() checks if the predicate is true for any one element in the stream. Here, again short-circuiting is applied and true is returned immediately after the first element.

		//noneMatch() checks if there are no elements matching the predicate. Here, it simply returns false as soon as it encounters 6, which is divisible by 3.
		 
		 List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
		 	boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
		    boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
		    boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
		    System.out.println(allEven   );
		    System.out.println(oneEven   );
		    System.out.println(noneMultipleOfThree   );
	}


	private static void distinctDemo() {
		List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
		 List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
		 System.out.println(distinctIntList);
	}


	private static void minMaxDemo() {
		Employee firstEmp = empList.stream()
			      .min((e1, e2) -> e1.getId() - e2.getId())
			      .orElseThrow(NoSuchElementException::new);
		 System.out.println(firstEmp);
		 
		 Employee lastEmp = empList.stream()
			      .max((e1, e2) -> e1.getId() - e2.getId())
			      .orElseThrow(NoSuchElementException::new);
		 System.out.println(lastEmp);
	}


	private static void sortedDemo() {
		List<Employee> employees = empList.stream()
				 .sorted().collect(Collectors.toList());
		 System.out.println(employees);
		 List<Employee> employees2 = empList.stream()
				 .sorted((e1,e2)->e2.getId()-e1.getId()).collect(Collectors.toList());
		 System.out.println(employees2);
	}


	

}


