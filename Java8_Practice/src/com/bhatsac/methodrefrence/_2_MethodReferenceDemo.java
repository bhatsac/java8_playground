package com.bhatsac.methodrefrence;

/**
 * 
 * @author bhatsac
 * This is a demo on method reference, This code demonstrates the basic usage of Method reference.
 * Method reference feature is newly introduced in v1.8 or Java8
 */


public class _2_MethodReferenceDemo {

	public  void m2(){
	
		for (int i = 0; i < 10; i++) {
			System.out.println("This is run by a thread using method ref"+ i);
			
		}
	}
	public static void main(String[] args) {
		
		Runnable r1=()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("This is run by a thread using lambda expressions"+ i);
				
			}
		};
		new Thread(r1).start();
		
		
		
		// Method reference feature in java8, instance reference.
		_2_MethodReferenceDemo thisCalss= new _2_MethodReferenceDemo();
		Runnable r2=thisCalss::m2;
		new  Thread(r2).start();
		
		
	}

}
