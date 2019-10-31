package com.bhatsac.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author bhatsac
 *Introduction
First of all, Java 8 Streams should not be confused with Java I/O streams (ex: FileInputStream etc); these have very little to do with each other.

Simply put, streams are wrappers around a data source, allowing us to operate with that data source and making bulk processing convenient and fast.

A stream does not store data and, in that sense, is not a data structure. It also never modifies the underlying data source.

This new functionality – java.util.stream – supports functional-style operations on streams of elements, such as map-reduce transformations on collections.

Let’s now dive into few simple examples of stream creation and usage – before getting into terminology and core concepts.
 */
public class _3_StreamsCreation {

	public static void main(String[] args) {
	
	//Stream Creation
	// Let’s first obtain a stream from an existing array:
		
		Employee[] arrayOfEmps = {
			    new Employee(1, "Jeff Bezos", 100000.0), 
			    new Employee(2, "Bill Gates", 200000.0), 
			    new Employee(3, "Mark Zuckerberg", 300000.0)
			};
		Stream.of(arrayOfEmps);
		
	//We can also obtain a stream from an existing list:
	    List<Employee> empList = Arrays.asList(arrayOfEmps);
		empList.stream();
		
	//Note that Java 8 added a new stream() method to the Collection interface.
	//And we can create a stream from individual objects using Stream.of():
		Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);
		
	//simply using Stream.builder():
		Stream.Builder<Employee> empStreamBuilder = Stream.builder();
		empStreamBuilder.accept(arrayOfEmps[0]);
		empStreamBuilder.accept(arrayOfEmps[1]);
		empStreamBuilder.accept(arrayOfEmps[2]);

		Stream<Employee> empStream = empStreamBuilder.build();
		//creating stream of arrays and printing it to the console.
		Arrays.stream(new int[]{1,2,3,4,5,6}).forEach(System.out::print);
		//System.out.println();
		//Stream<Integer> filter = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10}).filter(i->i<9);
		//filter.collect()
		//filter.collect(Integer::new,(objInt,i)-> {return;},(objInt,obj2Int)-> {List intList=new ArrayList<Integer>();intList.add(objInt);} );
		//.forEach(System.out::print);
		
		
	}
}



