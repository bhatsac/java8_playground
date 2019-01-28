package com.bhatsac.funinterfaces.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class _3_FIFunction {
	
	
	public static void main(String[] args) {
		
		Function<Integer, Integer> f1= i->i+i;
		Function<Integer, Integer> f2= i->i+i+i;
		Function<Integer, Integer> f3= i->i+i+i+i;
		Function<Integer, Integer> f4= i->i+i+i+i+i;
		
		
		
		System.out.println(f1.apply(f2.apply(f3.apply(f4.apply(1)))));
		
		
	}




	
	
	
}