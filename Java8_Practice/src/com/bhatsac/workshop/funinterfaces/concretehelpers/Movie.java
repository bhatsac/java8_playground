package com.bhatsac.workshop.funinterfaces.concretehelpers;

import java.util.ArrayList;
import java.util.List;


public class Movie {

	String name;
	List<MovieGenre> listOfMovieGenre =new ArrayList<>();
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MovieGenre> getListOfMovieGenre() {
		return listOfMovieGenre;
	}
	public void setMovieGenre(MovieGenre genre) {
		if(!this.listOfMovieGenre.contains(genre)){
			this.listOfMovieGenre.add(genre);
		}
	}
	
	
	
}
