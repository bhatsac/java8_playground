package com.bhatsac.funinterfaces.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		Consumer<Movie> c1= m-> System.out.println(m.getName());
		Consumer<Movie> c2= m-> System.out.println(m.getStatus());
		Consumer<Movie> c3= m-> System.out.println(m.getName()+"----"+m.getStatus());
		
		Consumer<Movie> chained=c1.andThen(c2).andThen(c3);
		c1.accept(new Movie("Mantralaya mahatme", "released")); // individual operation 
		
		// chains together all 3 consumers.
		chained.accept(new Movie("Mantralaya mahatme", "released"));
		
	}
}

class Movie{
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
	
}