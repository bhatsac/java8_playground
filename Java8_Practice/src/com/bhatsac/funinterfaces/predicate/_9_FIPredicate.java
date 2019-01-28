package com.bhatsac.funinterfaces.predicate;

import java.util.function.Predicate;

public class _9_FIPredicate {
	
	public static void main(String[] args) {
		
		// This is a static method which returns a predicate for what ever you pass.
		Predicate<String> p = Predicate.isEqual("Sachin");
		System.out.println(p.test("Sachin"));
	}
}
