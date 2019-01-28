package com.bhatsac.funinterfaces.predicate;

import java.util.function.Predicate;

public class _5_FIPredicateJoining2 {
	
	public static void main(String[] args) {
		String [] x ={"sunny","kumta","Keerthi","kagal","chitrigi","sachin"};
		
		System.out.println("------------------Starts with K-----------------");
		Predicate<String> p1 = s -> s.charAt(0)=='K' || s.charAt(0)=='k';
		m1(p1,x);
	}
	public static void m1(Predicate<String> p,String [] x){
		for (String s : x) {
			System.out.println(s+"->"+p.test(s));
		}
		System.out.println("-----------------------------------");
	}
}
