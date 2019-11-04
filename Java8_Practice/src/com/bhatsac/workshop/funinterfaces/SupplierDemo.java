package com.bhatsac.workshop.funinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
	
	static Supplier<List<String>> supplier=()-> Arrays.asList("Sachin","Sehwag","Ganguly","Dravid"); 
	
	public static void main(String[] args) {
		
		List<String> list = supplier.get();
		for (String listItem : list) {
			System.out.println(listItem);
		}
		
	}
}
