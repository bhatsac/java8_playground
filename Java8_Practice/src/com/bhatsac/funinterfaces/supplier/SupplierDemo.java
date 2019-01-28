package com.bhatsac.funinterfaces.supplier;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<Date> s1= () -> new Date();

		
		System.out.println(s1.get());
		System.out.println(s1.get());
		System.out.println(s1.get());
		
		Supplier<Integer> supplyRandom= () -> (int)(Math.random()*1000000)+1;
		System.out.println(supplyRandom.get());
		System.out.println(supplyRandom.get());
		System.out.println(supplyRandom.get());
		System.out.println(supplyRandom.get());
		System.out.println(supplyRandom.get());
		
	}
}

/*class Movie{
	String name;
	String status;
	
	
	public Movie(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}*/