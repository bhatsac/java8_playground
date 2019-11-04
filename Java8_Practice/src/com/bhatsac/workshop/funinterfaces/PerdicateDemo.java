package com.bhatsac.workshop.funinterfaces;

import java.util.function.Predicate;

import com.bhatsac.workshop.library.Author;
import com.bhatsac.workshop.library.Gender;

public class PerdicateDemo {

	/*Normal Predicate*/
	Predicate<Author> isFeMale= auth-> auth.getGender()==Gender.FEMALE;
	Predicate<Author> isMale  = auth-> auth.getGender()==Gender.MALE;
	
	Predicate<Author> isYoung = auth-> auth.getAge()<40;
	Predicate<Author> isOld = auth-> auth.getAge()>=40;
	
	/*Logical AND*/
	Predicate<Author> isFemaleYoung= isYoung.and(isFeMale);
	
	/*Logical OR*/
	
	Predicate<Author> isMaleORFemaleOld=  isOld.or(isMale);
	
	/*Logical Negate*/
	
	Predicate<Author> isOldNegate=  isYoung.negate();
	
	
}
