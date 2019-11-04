package com.bhatsac.workshop.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamsDemo {

	public static void main(String[] args) {
		//Create Streams
		Stream<String> players = Stream.of("sac","gan","dra","seh");
		players.forEach(s->System.out.println(s));
		
		//Using Stream Builder
		Builder<String> builder = Stream.builder();
		Stream<String> stringStream = builder.add("sac").add("gan").add("dra").add("seh").build();
		stringStream.forEach(StreamsDemo :: consumerPrint);
		
		
		// Streams starting from user given value
		Stream<Integer> iterate = Stream.iterate(5, i -> i+2);
		iterate.limit(9).forEach(i->System.out.println(i));
		
		//Infinite Stream generation
		Stream<Double> generate = Stream.generate(Math::random);
		generate.limit(1).forEach( d -> System.out.println(d));
		
		
		//Primitive streams
		IntStream intStream = IntStream.iterate(1, i ->i+1);
		intStream.limit(3).forEach(i -> System.out.println(i));
		
		IntStream.range(0, 25)
		.forEach(System.out::println);
	}
	
	public static void consumerPrint(String item){
		System.out.println(item);
	}
}
