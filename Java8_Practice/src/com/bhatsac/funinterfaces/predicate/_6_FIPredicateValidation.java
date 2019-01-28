package com.bhatsac.funinterfaces.predicate;

import java.util.function.Predicate;

public class _6_FIPredicateValidation {
	
	public static void main(String[] args) {
		String [] x ={"sunny","kumta","Keerthi","kagal","chitrigi","sachin"};
		
		System.out.println("------------------Starts with K-----------------");
		Predicate<String> p1 = s -> s.equalsIgnoreCase("sachin");
		m1(p1,x);
	}
	public static void m1(Predicate<String> p,String [] x){
		for (String s : x) {
			System.out.println(s+"->"+p.test(s));
		}
		System.out.println("-----------------------------------");
	}
}
