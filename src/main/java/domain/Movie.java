package domain;

import java.util.List;

public class Movie {

	private int id;
	private String name;
	private String type;
	private Double MovieRating;
	private List<Comment> comments;
	private List<Integer> actors;
	private List<Rating> rating;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getMovieRating() {
		return MovieRating;
	}
	public void setMovieRating(Double movieRating) {
		MovieRating = movieRating;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Integer> getActors() {
		return actors;
	}
	public void setActors(List<Integer> actors) {
		this.actors = actors;
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> raiting) {
		this.rating = raiting;
	}

}
