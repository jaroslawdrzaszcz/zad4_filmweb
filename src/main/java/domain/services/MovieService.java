package domain.services;

import java.util.ArrayList;
import java.util.List;

import domain.Actor;
import domain.Comment;
import domain.Movie;
import domain.Rating;

public class MovieService {

	private static List<Movie> db = new ArrayList<Movie>();
	private static int currentId = 1;
	
	public List<Movie> getAll(){
		return db;
	}
	
	public Movie getById(int id){
		for(Movie m:db){
			if(m.getId()==id)
				return m;
		}
		return null;
	}
	
	public void add(Movie m){
		m.setId(currentId++);
		db.add(m);
	}
	
	public void update(Movie movie){
		for(Movie m:db){
			if(m.getId()==movie.getId()){
				m.setName(movie.getName());
				m.setType(movie.getType());
			}
		}
	}

	/*public void delete(Movie m){
		db.remove(m);
	}*/
	public void delete (Movie movie) {
		db.remove(movie);
	}
	
	public void addComment(Movie movie, Comment comment){
		comment.setId(movie.getComments().size());
		movie.getComments().add(comment);
	}
	
	public void deleteComment(Movie movie, int commentId){
		db.get(movie.getId()).getComments().remove(commentId);
	}
	
	public void addRating(Movie movie, Rating rating){
		rating.setId(movie.getRating().size());
		movie.getRating().add(rating);
		
		double avg = 0.0;
		double sum = 0;
		for(Rating r:movie.getRating()){
			sum = sum + r.getRating();
		}
		avg = sum/movie.getRating().size();
		movie.setMovieRating(avg);
	}
	
	public List<Actor> addActor(int movieId){
		MovieService db = new MovieService();
		List<Actor> actorsForMovie = new ArrayList<Actor>();
		List<Actor> actorsDb = new ActorService().getAll();
		
		for (Movie m:db.getAll()){
			if(m.getId() == movieId){
				for (int id : m.getActors()){
					for(Actor a: actorsDb){
						if(a.getId() == id){
							actorsForMovie.add(a);
						}
					}
				}
			}
		}
		return actorsForMovie;
	}
	
	public void deleteActor(Movie movie, int actorId) {
	db.get(movie.getActors().remove(actorId));
	}
}

