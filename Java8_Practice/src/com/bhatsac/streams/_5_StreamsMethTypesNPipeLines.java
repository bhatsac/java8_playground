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

public class _5_StreamsMethTypesNPipeLines {
	
	// This is the code snippet which creates setup for analyzing features of java8
	 private static Employee[] arrayOfEmps = {
		        new Employee(1, "Jeff Bezos", 100000.0), 
		        new Employee(2, "Bill Gates", 200000.0), 
		        new Employee(3, "Mark Zuckerberg", 300000.0)
		    };

		    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
		    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	
public static void main(String[] args) {
	
	
	//1. ForEach()
		System.out.println("<:><:><:>Java8 ForEach() Demo Begins\n");
		forEachDemo();
		System.out.println("\n<:><:><:>Java8 ForEach() Demo Ends\n");
		
	//2. map()	
		System.out.println("<:><:><:>Java8 map() Demo Begins\n");
		mapDemo();
		System.out.println("\n<:><:><:>Java8 map() Demo Ends\n");
	
	//3. collect()
		System.out.println("<:><:><:>Java8 collect() Demo Begins\n");
		collectDemo();
		System.out.println("\n<:><:><:>Java8 collect() Demo Ends\n");
		
	//4. filter
		System.out.println("<:><:><:>Java8 filter() Demo Begins\n");
		filterDemo();
		System.out.println("\n<:><:><:>Java8 filter() Demo Ends\n");
		
	//5. findFirst
		System.out.println("<:><:><:>Java8 findFirst() Demo Begins\n");
		findFirstDemo();
		System.out.println("\n<:><:><:>Java8 findFirst() Demo Ends\n");
		
	//6. toArray
		System.out.println("<:><:><:>Java8 toArray() Demo Begins\n");
		toArrayDemo();
		System.out.println("\n<:><:><:>Java8 toArray() Demo Ends\n");
		
	//7. flatMap
		System.out.println("<:><:><:>Java8 flatMap() Demo Begins\n");
		flatMapDemo();
		System.out.println("\n<:><:><:>Java8 flatMap() Demo Ends\n");
	//8. peek
		System.out.println("<:><:><:>Java8 peek() Demo Begins\n");
		peekDemo();
		System.out.println("\n<:><:><:>Java8 peek() Demo Begins\n");
}


private static void peekDemo() {
	//We saw forEach() earlier in this section, which is a terminal operation. 
	//However, sometimes we need to perform multiple operations on each element of the stream before any terminal operation is applied.
	 empList.stream()
	  .peek(e -> e.setSalary(e.getSalary()+(10.0)))  // this is to add the increment
	  .peek(System.out::println) // this is to print the same object after increment.
	  .collect(Collectors.toList());
	//peek() can be useful in situations like this. Simply put, 
	//it performs the specified operation on each element of the stream and returns a new stream which can be used further. peek() is an intermediate operation:
	//Here, the first peek() is used to increment the salary of each employee. The second peek() is used to print the employees. Finally, collect() is used as the terminal operation.
}


private static void flatMapDemo() {
	//A stream can hold complex data structures like Stream<List<String>>. 
	//In cases like this, flatMap() helps us to flatten the data structure to simplify further operations:
	List<List<String>> namesNested = Arrays.asList( 
		      Arrays.asList("Jeff", "Bezos"), 
		      Arrays.asList("Bill", "Gates"), 
		      Arrays.asList("Mark", "Zuckerberg"));
	

	System.out.println(namesNested);
	List<String> namesFlatStream = namesNested.stream()
		      .flatMap(Collection::stream)
		      .collect(Collectors.toList());
	System.out.println(namesFlatStream);
	//Notice how we were able to convert the Stream<List<String>> to a simpler Stream<String> – using the flatMap() API.
}

private static void flatMapDemo2() {
	//A stream can hold complex data structures like Stream<List<String>>. 
	//In cases like this, flatMap() helps us to flatten the data structure to simplify further operations:
	List<List<List<String>>> namesNested =Arrays.asList( Arrays.asList( 
		      Arrays.asList("Jeff", "Bezos"), 
		      Arrays.asList("Bill", "Gates"), 
		      Arrays.asList("Mark", "Zuckerberg")),
		      Arrays.asList( 
				      Arrays.asList("Jeff", "Bezos"), 
				      Arrays.asList("Bill", "Gates"), 
				      Arrays.asList("Mark", "Zuckerberg")
			
			));
	

	System.out.println(namesNested);
	List<String> namesFlatStream = namesNested.stream()
		      .flatMap(Collection::stream)
		      .flatMap(Collection::stream)
		      .collect(Collectors.toList());
	System.out.println(namesFlatStream);
	//Notice how we were able to convert the Stream<List<String>> to a simpler Stream<String> – using the flatMap() API.
}

private static void toArrayDemo() {
	//We saw how we used collect() to get data out of the stream. 
	//If we need to get an array out of the stream, we can simply use toArray():	
	Employee[] employees = empList.stream().toArray(Employee[]::new); // method reference again replacing generic array and apply with constructor reference.
	System.out.println(employees);
	//The syntax Employee[]::new creates an empty array of 
	//Employee – which is then filled with elements from the stream.
}


private static void findFirstDemo() {
	//TODO Optional Interface
	//findFirst() returns an Optional for the first entry in the stream; the Optional can, of course, be empty:
	 Integer[] empIds = { 1, 2, 3, 4 };
	 Employee employee = Stream.of(empIds)
		      .map(employeeRepository::findById)
		      .filter(e -> e != null)
		      .filter(e -> e.getSalary() > 100010)
		      .findFirst()
		      .orElse(null);
	 System.out.println(employee);
	//Here, the first employee with the salary greater than 100000 is returned. If no such employee exists, then null is returned.
}

public static boolean  filterMethRefDemo(Employee e){
	return e!=null;
}
private static void filterDemo() {
	//Next, let’s have a look at filter(); 
	//this produces a new stream that contains elements of the original stream that pass a given test (specified by a Predicate).

	//Let’s have a look at how that works:
	
	Integer[] empIds = { 1, 2, 3, 4 };
	  List<Employee> employees = Stream.of(empIds)
		      .map(employeeRepository::findById)
		      .filter(_5_StreamsMethTypesNPipeLines::filterMethRefDemo)
		      .filter(e -> e.getSalary() > 200000)
		      .collect(Collectors.toList());
	  System.out.println(employees);
}
	
	
	/**
	 * This code snippet is to demonstrate the feature of collect
	 */
	private static void collectDemo() {
		//We saw how collect() works in the previous example;
		//its one of the common ways to get stuff out of the stream once we are done with all the processing:
		//collect() performs mutable fold operations (repackaging elements to some data structures and applying some additional logic,
		//concatenating them, etc.) on data elements held in the Stream instance.
		List<Employee> employees = empList.stream().collect(Collectors.toList());
		System.out.println(employees);
		//The strategy for this operation is provided via the Collector interface implementation. 
		//In the example above, we used the toList collector to collect all Stream elements into a List instance.
	}

	/**
	 * This code snippet demonstrates how to use map feature in streams
	 * 
	 */
	private static void mapDemo() {
		//map()
				//map() produces a new stream after applying a function to each element of the original stream. 
				//The new stream could be of different type.
		
				//The following example converts the stream of Integers into the stream of Employees:
				
				Integer[] empIds = { 1, 2 };
				
				List<Employee> employees =Stream.of(empIds)  // converting array to stream
						.map(employeeRepository::findById) //Instead of apply we have replaced apply by using findByid using method reference ::
						.collect(Collectors.toList());    // collecting the output using the collector
				System.out.println(employees);
				
			//OR -- instead of method reference we can directly use lambda expressions
				
				List<Employee> employees2 =Stream.of(empIds)  // converting array to stream
						.map( (id)->{  for (Employee emp : empList) {
							            if (emp.getId() == id) {
							                return emp;
							            }
				        			}
										return null;
							}) 
						.collect(Collectors.toList());    // collecting the output using the collector
				System.out.println(employees2);
				
			//OR -- further simplifying
				Function<Integer,Employee> funEmployee=(id)->{ 
					for (Employee emp : empList) {
		            if (emp.getId() == id) {
		                return emp;
		            }
				}
					return null;
				};
				
				List<Employee> employees3 =Stream.of(empIds)  // converting array to stream
						.map(funEmployee) 
						.collect(Collectors.toList());    // collecting the output using the collector
				System.out.println(employees3);
	}

/**
 	* This is an example demostrating forEach Feature in Streams.	
 * //forEach()
		//forEach() is simplest and most common operation; it loops over the stream elements,
		//calling the supplied function on each element.
		//The method is so common that is has been introduced directly in Iterable, Map etc:
 */
	private static void forEachDemo() {
		List<Employee> asList = Arrays.asList(arrayOfEmps);
//forEach()
		//forEach() is simplest and most common operation; it loops over the stream elements,
		//calling the supplied function on each element.
		//The method is so common that is has been introduced directly in Iterable, Map etc:
		
		// for each element i have added 10 to salary, foreach takes consumer interface.
		asList.stream().forEach(e->e.setSalary(e.getSalary()+10.00));
		asList.stream().forEach(e->System.out.println(e.toString()));
		asList.stream().forEach(System.out::print);
	}
}



