package com.bhatsac.funinterfaces.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class _2_FIFunction {
	
	
	public static void main(String[] args) {
		
		List<Student> stuList=new ArrayList<Student>();
		
		stuList.add((new Student("sac", 80.00)));
		stuList.add((new Student("kee", 90.00)));
		stuList.add((new Student("sur", 95.00)));
		stuList.add((new Student("sud", 100.00)));
		stuList.add((new Student("yyy", 50.00)));
		stuList.add((new Student("xxx", 32.00)));
		stuList.add((new Student("mmm", 65.00)));
		
		
		Function<List<Student>, Map<Student,String>> fn1= sList ->
		{
			Map<Student,String> map =new HashMap<Student,String>();
			for (Student student : sList) {
				map.put(student,
						student.getMarks()>=90.00
							?"DIST"
							:student.getMarks()<90.00 && student.getMarks()>=60
								?"FC"
								:student.getMarks()<60.00 && student.getMarks()>=35.00
								?"SC"
								:"FAIL"		
								
						);
								
			}
			return map;
		};
		
		Map<Student, String> apply = fn1.apply(stuList);
		for (Entry<Student, String> entry: apply.entrySet()) {
			System.out.println(entry.getKey()+ "->" +entry.getValue());
			
		}
		//System.out.println(fn1.apply("This is awesome!"));
		
		
		
	}

}

class Student{
	
	private String name;
	private double marks;
	public Student(String name, double marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
	
	
	
	
}