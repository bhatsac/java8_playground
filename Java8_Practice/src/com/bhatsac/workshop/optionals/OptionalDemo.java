package com.bhatsac.workshop.optionals;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.bhatsac.workshop.library.Author;
import com.bhatsac.workshop.library.Gender;

public class OptionalDemo {

	public static void main(String[] args) {
		//Printing optional
		Author auth= new Author("Baby Bhat", 0, Gender.MALE);
		Optional<Author> authOptional= Optional.of(auth);
		authOptional.ifPresent(System.out::println);
		
		Optional<Author> authOptiona2= Optional.ofNullable(null);
		if(authOptiona2.isPresent())
			authOptiona2.ifPresent(System.out::println);
		
		Optional<Author> authOptiona3= Optional.ofNullable(auth);
		if(authOptiona3.isPresent())
			authOptiona3.ifPresent(System.out::println);
		
		Optional<Author> authOptiona4= Optional.ofNullable(null);
		//System.out.println(authOptiona4.get()); no such element exception
		
		/*System.out.println(authOptiona4.orElseGet(()-> {return new Author("Baby Bhat", 0, Gender.MALE);}));
		authOptiona4.orElseThrow(NoSuchElementException::new);*/
		
		Author auth3= new Author("Baby Bhat", 1, Gender.MALE);
		Optional<Author> authOptiona5= Optional.of(auth3);
		authOptiona5.filter(auth1 -> auth1.getGender()==Gender.MALE).ifPresent(System.out::println);
		
		
		
	}
}
