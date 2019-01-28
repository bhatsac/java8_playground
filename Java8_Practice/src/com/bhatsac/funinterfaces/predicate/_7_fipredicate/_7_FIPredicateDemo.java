package com.bhatsac.funinterfaces.predicate._7_fipredicate;

import java.util.function.Predicate;

public class _7_FIPredicateDemo {

	public static void main(String[] args) {

		SoftwareEngineer [] list ={
			new SoftwareEngineer("sachin",31, false),
			new SoftwareEngineer("padmanabha",31, false),
			new SoftwareEngineer("ankit",31, true),
			new SoftwareEngineer("abu",31, false)
		};
		Predicate<SoftwareEngineer> p= se-> se.age>=18 && se.isHavingGF;
		testCondition(p, list);
	}
	
	public static void testCondition(Predicate<SoftwareEngineer> p, SoftwareEngineer [] list){
		for (SoftwareEngineer softwareEngineer : list) {
			System.out.println(p.test(softwareEngineer));
		}
	}
}
