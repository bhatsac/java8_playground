package com.bhatsac.funinterfaces.predicate;

import java.util.function.Predicate;

public class _4_FIPredicateJoining {
	
	public static void main(String[] args) {
		int [] x ={10,11,4,5,6,12,15};
		
		Predicate<Integer> p1 =i -> i>10;
		Predicate<Integer> p2 =i -> i%2==0;
		System.out.println("Numbers greater than 10 are?");
		m1(p1, x);
		System.out.println("Numbers which are even?");
		m1(p2, x);
		System.out.println("Numbers less than 10 are?");
		m1(p1.negate(), x);
		System.out.println("Numbers are odd?");
		m1(p2.negate(), x);
		System.out.println("Numbers which are even and greater than 10?");
		m1(p1.and(p2), x);
		System.out.println("Number which are greater than 10 OR even?");
		m1(p1.or(p2), x);
	}
	
	public static void m1(Predicate<Integer> p,int [] x){
		for (int i : x) {
			System.out.println(i+"->"+p.test(i));
		}
		System.out.println("-----------------------------------");
	}
}
