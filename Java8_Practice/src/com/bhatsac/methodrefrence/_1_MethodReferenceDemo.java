package com.bhatsac.methodrefrence;

/**
 * 
 * @author bhatsac
 * This is a demo on method reference, This code demonstrates the basic usage of Method reference.
 * Method reference feature is newly introduced in v1.8 or Java8
 */


public class _1_MethodReferenceDemo {

	public static void m2(){
		System.out.println("This is method reference!!");
	}
	public static void main(String[] args) {
		
		MethodRef mRef=() -> {
			System.out.println("This is awesome!");
		};
		mRef.m1();
		
		
		/// Method reference feature in java8, static reference.
		MethodRef mRef2=_1_MethodReferenceDemo::m2;
		mRef2.m1();
		
	}

}
