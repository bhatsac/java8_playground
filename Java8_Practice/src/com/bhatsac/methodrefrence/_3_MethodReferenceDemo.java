package com.bhatsac.methodrefrence;

/**
 * 
 * @author bhatsac
 * This is a demo on method reference, This code demonstrates the basic usage of Method reference.
 * Method reference feature is newly introduced in v1.8 or Java8
 */


public class _3_MethodReferenceDemo {
	private String name;
	
	_3_MethodReferenceDemo(){
			this.name="bhatsac";	
	}
	_3_MethodReferenceDemo(String name){
		this.name=name;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		/// Method reference feature in java8, constructor reference.
		MethodRefDemo ref=_3_MethodReferenceDemo:: new;		
		_3_MethodReferenceDemo refObj = ref.get();
		System.out.println(refObj.getName());
		
		// with arguments
		
		MethodRefDemo2 ref2=_3_MethodReferenceDemo:: new;		
		_3_MethodReferenceDemo refObj2 = ref2.get("sac");
		System.out.println(refObj2.getName());
		
	}

}
// we need here the seperate SAM for other constructor is because for Method reference only arguments should be matched.

 interface MethodRefDemo{
	
	public _3_MethodReferenceDemo get();
}

 interface MethodRefDemo2{
		
	public _3_MethodReferenceDemo get(String name);
}
