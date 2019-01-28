package com.bhatsac.funinterfaces.function;

import java.util.function.Function;

public class _1_FIFunction {
	
	
	public static void main(String[] args) {
		
		Function<String, Integer> fn1= s-> s.length();
		
		System.out.println(fn1.apply("This is awesome!"));
		
		
		Function<Integer, Integer> fn2= i-> i*i;
		
		System.out.println(fn2.apply(9));
		
	}

}
