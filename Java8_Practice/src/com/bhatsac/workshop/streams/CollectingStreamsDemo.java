package com.bhatsac.workshop.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bhatsac.workshop.library.Author;
import com.bhatsac.workshop.library.Gender;

public class CollectingStreamsDemo {
 
	// There are 2 variations of collecting the streams, basic and advanced
	public static void main(String[] args) {
		
		
		
		collectorsBasic();
		
		
		Author auth1= new Author("A1", 25, Gender.MALE);
		Author auth2= new Author("A2", 24, Gender.FEMALE);
		Author auth3= new Author("A3", 27, Gender.MALE);
		Author auth4= new Author("A4", 35, Gender.FEMALE);
		Author auth5= new Author("A5", 45, Gender.MALE);
		Author auth6= new Author("A6", 65, Gender.FEMALE);
		Author auth7= new Author("A7", 35, Gender.MALE);
		Author auth8= new Author("A8", 15, Gender.MALE);
		Author auth9= new Author("A9", 65, Gender.FEMALE);
		Author auth10= new Author("A10", 85, Gender.MALE);
		Author auth11= new Author("A11", 95, Gender.FEMALE);
		Author auth12= new Author("A12", 75, Gender.MALE);
		Author auth13= new Author("A13", 51, Gender.FEMALE);
		
		List<Author> listAuth= new ArrayList<>();
		listAuth.add(auth1);
		listAuth.add(auth2);
		listAuth.add(auth3);
		listAuth.add(auth4);
		listAuth.add(auth5);
		listAuth.add(auth6);
		listAuth.add(auth7);
		listAuth.add(auth8);
		listAuth.add(auth9);
		listAuth.add(auth10);
		listAuth.add(auth11);
		listAuth.add(auth12);
		listAuth.add(auth13);
		
		
		 listAuth.stream()
		.sorted( (Author au1,  Author au2) -> (au1.getAge()-au2.getAge()))
	    .collect(Collectors.toList())
	    .stream()
	    .collect(Collectors.groupingBy((Author auth) -> auth.getGender()))
	    .values()
	    .stream()
	    .flatMap(listAuthor -> listAuthor.stream())
	    .collect(Collectors.toList())
	    .stream()
	    .forEach(System.out::println);
		 
	   
		
		Map<Gender, List<Author>> collect = listAuth.stream().collect(Collectors.groupingBy( (Author auth)-> auth.getGender()));
		/*collect.forEach(key,value -> 
				);*/
		
		
		/*collect.entrySet().stream()
		.map(entry -> entry.getValue())
		.sorted(List<Author> listAuth->listAuth);*/
		
	
		
		
	}

	
	private static void collectorsBasic() {
		//Collectors To List
		Stream.of(1,2,3,4,5,6,7,8,9,23,34,54,76,1,3,4,5,1,2).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("--------------------------------");
		//Collectors To Set
		Stream.of(1,2,3,4,5,6,7,8,9,23,34,54,76,1,3,4,5,1,2).collect(Collectors.toSet()).forEach(System.out::println);
		//To Map
		Map<Integer, Integer> collect = Stream.of(1,2,3,4,5,6,7,8,9)
		.collect(
				Collectors.toMap( 
						(i) -> i, (Integer i) -> i )
				);
		
		collect
			.forEach((i , j) -> System.out.println("Key="+i + " Value="+j) );
	}
}
