package com.bhatsac.funinterfaces.predicate;

import java.util.function.Predicate;

public class _1_FIPredicate {
	
	public static void main(String[] args) {
		Predicate<Integer> p = i -> (i>10); 
		System.out.println(p.test(5));
		System.out.println(p.test(6));
		System.out.println(p.test(7));
		System.out.println(p.test(11));
	}
}
