package com.bhatsac.funinterfaces.predicate;

import java.util.function.Predicate;

public class _2_FIPredicate {
	
	public static void main(String[] args) {
		Predicate<String> p = s -> s.length()>10;
		System.out.println(p.test("abc"));//false
		System.out.println(p.test("asdsadsad"));//false
		System.out.println(p.test("sachin"));//false
		System.out.println(p.test("asdsadsadsadsad"));//true
	}
}
