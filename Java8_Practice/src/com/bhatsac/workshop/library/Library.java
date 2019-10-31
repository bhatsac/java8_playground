package com.bhatsac.workshop.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Book> books;

	public Library() {
		books=new ArrayList<>();
	}
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void setBook(Book book) {
		this.books.add(book);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Library [books=" + books + "]";
	}
	
	
	
	
}
