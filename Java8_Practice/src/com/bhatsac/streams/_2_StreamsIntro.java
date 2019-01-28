package com.bhatsac.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 
 * @author bhatsac
 *
 *in this we will check few methods
 *collect()
 *count()
 *sorted()
 *min() // this takes comparator as input
 *max() // this takes comparator as input
 *forEach() method
 */
public class _2_StreamsIntro {

	public static void main(String[] args) {
		List<String> intList= new ArrayList<String>();
		intList.add("Sachin");
		intList.add("Sehwag");
		intList.add("Virat");
		intList.add("Gautam");
		intList.add("ABD");
		intList.add("Rahul Dravid");
		intList.add("Gilchrist");
		
		
		
		
		//with streams finding a even number, from java8 onwards.
		List<String> filteredObjects = intList.stream().filter(s->s.length()>6).collect(Collectors.toList());
		System.out.println(filteredObjects);
		List<String> filteredObjects2 = intList.stream().filter(s->s.length()<=6).collect(Collectors.toList());
		System.out.println(filteredObjects2);
		
		//with maps using condition on collections, from java8 onwards.
		List<String> mapObjects = intList.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(mapObjects);
		
		
		//with maps using condition on collections, from java8 onwards.
		long count = intList.stream().filter(s->s.length()<=6).count();
		System.out.println(count);
		
		
		
		// Sorting check
		List<Integer> integerList= new ArrayList<Integer>();
		integerList.add(10);
		integerList.add(11);
		integerList.add(12);
		integerList.add(13);
		integerList.add(14);
		integerList.add(1);
		integerList.add(0);
		integerList.add(4);
		integerList.add(21);
		integerList.add(16);
		integerList.add(17);

		//Default natural sorting order.
		System.out.println(integerList.stream().sorted().collect(Collectors.toList()));
		
		//Using comparator and reversing the order		
		System.out.println(integerList.stream().sorted((obj1, obj2)->{ return (obj1>obj2)?-1:(obj1<obj2)?1:0; }).collect(Collectors.toList()));
		//OR
		//Using comparator and reversing the order		
		System.out.println(integerList.stream().sorted((obj1, obj2)->{ return obj2.compareTo(obj1);}).collect(Collectors.toList()));
	
	
		// Min and max method usage, fot this the list has to be sorted.
		System.out.println(integerList.stream().min((obj1, obj2)->{ return obj1.compareTo(obj2);}).get());
		System.out.println(integerList.stream().max((obj1, obj2)->{ return obj1.compareTo(obj2);}).get());
		System.out.println(integerList.stream().max((obj1, obj2)->{ return obj2.compareTo(obj1);}).get());
		
		
		
		List<String> oneMoreList= new ArrayList<String>();
		oneMoreList.add("Sachin");
		oneMoreList.add("Sehwag");
		oneMoreList.add("Virat");
		oneMoreList.add("Gautam");
		oneMoreList.add("ABD");
		oneMoreList.add("Rahul Dravid");
		oneMoreList.add("Gilchrist");
		
		oneMoreList.stream().forEach(s->System.out.print(s+","));
		
		
		// toArray() using streams
		Integer array[]=integerList.stream().toArray(Integer[] :: new);
		System.out.println(array.toString());
		
		// toArray() using streams
		String array3[]=oneMoreList.stream().toArray(String[]:: new);
		System.out.println(array3.toString());
	}
}
