package com.bhatsac.funinterfaces.predicate;

import java.util.function.Predicate;


/**
 * 
 * Remember predicate from Math class in school? Yeah, something like a function that takes in a value and returns true or false.
 * In Java 8, java.util.function.Predicate was introduced that behaves the same way and can be used as an assignment target 
 * in lambda expressions and functional interfaces. 
 * The functional method of Predicate is test(Object).
 * @author bhatsac
 *
 */
public class _1_FIPredicate {
	
	public static void main(String[] args) {
		
		Predicate<String> s  = k-> "sac".equalsIgnoreCase(k);
		Predicate<Integer> p = i -> (i>10); 
		
		
		System.out.print(s.test("abc"));
		System.out.println(p.test(5));
		System.out.println(p.test(6));
		System.out.println(p.test(7));
		System.out.println(p.test(11));
	}
}
