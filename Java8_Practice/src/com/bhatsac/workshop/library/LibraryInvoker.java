package com.bhatsac.workshop.library;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LibraryInvoker {

	public static void main(String[] args) {
		
		Library buildLibrary = buildLibrary();
		
		performOperationsOnLibrary(buildLibrary);
		
	}
	private static void performOperationsOnLibrary(Library buildLibrary) {
		buildLibrary.getBooks()
		.stream()
		.map(book -> book.getAuthor()) // Map transfored the list of books streams to author streams.
		.filter(author -> author.getAge()<40)
		.distinct()  // Ensures that kuvempu is not awarded the young achievers twice
		.map(author -> author.getName()+" is conferred with young achivers award")
		.forEach(LibraryInvoker::publishAward); // Method reference
		
		
		
		Map<List<String>, List<Author>> collect = buildLibrary.getBooks()
		.stream()
		.map(book -> book.getAuthor()) 
		.collect(Collectors.groupingBy((Author auth) -> Arrays.asList(auth.getName(),String.valueOf(auth.getAge()))));
		
		System.out.println(collect);
		//{[PVS, 36]=[com.bhatsac.workshop.library.Author@d136419e], [Kuvempu, 25]=[com.bhatsac.workshop.library.Author@3c5b2f3d, com.bhatsac.workshop.library.Author@3c5b2f3d], [MVK, 75]=[com.bhatsac.workshop.library.Author@fe5125c9], [R VP, 45]=[com.bhatsac.workshop.library.Author@2b295e1], [DVG, 65]=[com.bhatsac.workshop.library.Author@d13dfa79], [MVC, 67]=[com.bhatsac.workshop.library.Author@d142fa12], [Masti, 56]=[com.bhatsac.workshop.library.Author@5a0bc503], [KBC, 90]=[com.bhatsac.workshop.library.Author@fe56c290]}
		
		
		List<Author> sortedByAge = buildLibrary.getBooks()
		.stream()
		.map(books -> books.getAuthor())
		.sorted((Author auth1, Author auth2) -> Integer.valueOf(auth1.getAge()).compareTo(Integer.valueOf(auth2.getAge())))
		.collect(Collectors.toList());
		
		System.out.println(sortedByAge);
		
		
		
		
		
				Author orElseThrow = buildLibrary.getBooks()
				.stream()
				.map(books -> books.getAuthor())
				.min(Comparator.comparing(Author::getAge))
				.orElseThrow(NoSuchElementException::new);
				
				System.out.println(orElseThrow);
				
		
		Integer reduce = buildLibrary.getBooks()
				.stream()
				.map(books -> books.getAuthor())
				.map(auth -> auth.getAge())
				.reduce(0,Integer::sum );
				
				
				System.out.println(reduce);
	}
	
	private static void publishAward(String message){
		System.out.println(message);
	}
	private static Library buildLibrary() {
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
		return lb;
	}
	
	
	
	
}
