package domain;

import java.util.List;

public class Actor {

	private int id;
	private String name;
	private String surname;
	private List<Integer> movies;
	
	public List<Integer> getMovies() {
		return movies;
	}
	public void setMovies(List<Integer> movies) {
		this.movies = movies;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
