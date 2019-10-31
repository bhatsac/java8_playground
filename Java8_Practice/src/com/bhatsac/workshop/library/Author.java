package com.bhatsac.workshop.library;

import java.util.List;

public class Author {

	private String name;
	private int age;
	private Gender gender;
	
	private List<Book> publishedBooks;
	
	
	public Author(String name, int age,Gender gender){
		this.age=age;
		this.name=name;
		this.gender=gender;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		age = age;
	}
	public List<Book> getPublishedBooks() {
		return publishedBooks;
	}
	public void setPublishedBooks(List<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publishedBooks == null) ? 0 : publishedBooks.hashCode());
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
		Author other = (Author) obj;
		if (age != other.age)
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publishedBooks == null) {
			if (other.publishedBooks != null)
				return false;
		} else if (!publishedBooks.equals(other.publishedBooks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", age=" + age + ", gender=" + gender + ", publishedBooks=" + publishedBooks
				+ "]";
	}
	
	
	
}
