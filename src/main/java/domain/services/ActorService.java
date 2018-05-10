package domain.services;

import java.util.ArrayList;
import java.util.List;

import domain.Actor;
import domain.Movie;

public class ActorService {

	private static List<Actor> db = new ArrayList<Actor>();
	private static int currentId = 1;
	
	public List<Actor> getAll(){
		return db;
	}
	
	public Actor getById(int id){
		for(Actor a:db){
			if(a.getId()==id)
				return a;
		}
		return null;
	}
	
	public void add(Actor a){
		a.setId(currentId++);
		db.add(a);
	}
	
	public void update(Actor actor){
		for(Actor a:db){
			if(a.getId()==actor.getId()){
				a.setName(actor.getName());
				a.setSurname(actor.getSurname());
			}
		}
	}

	public void delete(Actor a){
		db.remove(a);
	}

	public void addMovie (Actor actor, Movie movie) {
		MovieService moviesDb = new MovieService();
		
		for (Movie m : moviesDb.getAll()) {
			if (m.getId() == movie.getId()) {
				actor.getMovies().add(m.getId()); // do sprawdzenia
				if (m.getActors() == null) {
					m.setActors(new ArrayList<Integer>());
				}	
				m.getActors().add(actor.getId());
			}
		}
	}

	public void deleteMovie(Actor actor, int movieId) {
	db.get(actor.getMovies().remove(movieId));
	}
}
