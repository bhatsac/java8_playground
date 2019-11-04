package com.bhatsac.workshop.funinterfaces;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bhatsac.workshop.funinterfaces.concretehelpers.Movie;
import com.bhatsac.workshop.funinterfaces.concretehelpers.MovieGenre;
import com.bhatsac.workshop.library.Author;
import com.bhatsac.workshop.library.Book;
import com.bhatsac.workshop.library.Gender;
import com.bhatsac.workshop.library.Library;

public class FunctionDemo {

	public static void main(String[] args) {
		//Based on the gender fetch the all the authors..
		
		Author ath1= new Author("Kuvempu", 25, Gender.MALE);
		Book bk1=new Book("ISBM-0001", ath1);
		
		
		
		Author ath2= new Author("Masti", 56, Gender.MALE);
		Book bk2=new Book("ISBM-0002", ath2);
		
		Author ath3= new Author("R VP", 45, Gender.FEMALE);
		Book bk3=new Book("ISBM-0004", ath3);
		
		Author ath4= new Author("DVG", 65, Gender.MALE);
		Book bk4=new Book("ISBM-0007", ath4);
		
		Author ath5= new Author("MVK", 75, Gender.FEMALE);
		Book bk5=new Book("ISBM-0008", ath5);
		
		Author ath6= new Author("MVC", 67, Gender.MALE);
		Book bk6=new Book("ISBM-0008", ath6);
		
		Author ath7= new Author("PVS", 36, Gender.MALE);
		Book bk7=new Book("ISBM-0008", ath7);
		
		Author ath8= new Author("KBC", 90, Gender.FEMALE);
		Book bk8=new Book("ISBM-0008", ath8);
		
		Book bk9=new Book("ISBM-0009", ath1);
		
		Library lb = new Library();
		
		lb.setBook(bk1);
		lb.setBook(bk2);
		lb.setBook(bk3);
		
		lb.setBook(bk4);
		
		lb.setBook(bk5);
		
		lb.setBook(bk6);
		
		lb.setBook(bk7);
		lb.setBook(bk8);
		lb.setBook(bk9);
		
		
		
		// Here we are passing Gender to get all the authors belonging to specific gender.
					Function<Gender,List<Author>> getAuthorsForGenders =(Gender gender) -> {return lb.getBooks().stream()
	   				.map(book -> book.getAuthor())
	   				.filter((Author auth) -> auth.getGender()==gender)
	   				.collect(Collectors.toList()); };
	   				
	   				System.out.println(getAuthorsForGenders.apply(Gender.MALE));
	   				System.out.println(getAuthorsForGenders.apply(Gender.FEMALE));
	   				
	   				
	   				
	   Movie mv= new Movie();
	   mv.setMovieGenre(MovieGenre.ACTION);
	   mv.setMovieGenre(MovieGenre.COMEDY);
	   mv.setMovieGenre(MovieGenre.ACTION);
	   mv.setMovieGenre(MovieGenre.ADVENTURE);
	   

	   				
	}
}
