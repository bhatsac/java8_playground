package com.bhatsac.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _1_StreamsIntro {

	public static void main(String[] args) {
		List<Integer> intList= new ArrayList<Integer>();
		intList.add(10);
		intList.add(11);
		intList.add(12);
		intList.add(13);
		intList.add(14);
		
		// without streams finding a even number, before java8
		for (Integer integer : intList) {
			if(integer%2==0){
				System.out.print(integer+"\t");
			}
		}
		
		//with streams finding a even number, from java8 onwards.
		List<Integer> collect = intList.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(collect);
		
		
		//with maps using condition on collections, from java8 onwards.
		List<Integer> mapObjects = intList.stream().map(i->i*2).collect(Collectors.toList());
		System.out.println(mapObjects);
	}
}
