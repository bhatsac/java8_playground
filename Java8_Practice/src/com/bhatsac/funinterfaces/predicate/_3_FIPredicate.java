package com.bhatsac.funinterfaces.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class _3_FIPredicate {
	
	public static void main(String[] args) {
		Predicate<Collection<?>> p = c->c.isEmpty();
		
		
		ArrayList<Integer> al= new ArrayList<Integer>();
		System.out.println(p.test(al));//true
		
		al.add(10);
		System.out.println(p.test(al));//false
		
		
	}
}
