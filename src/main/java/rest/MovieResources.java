package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Actor;
import domain.Comment;
import domain.Movie;
import domain.Rating;
import domain.services.MovieService;

@Path("/movies")
public class MovieResources {
	
	private MovieService db = new MovieService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAll(){
		return db.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Movie Movie){
		db.add(Movie);
		return Response.ok(Movie.getId()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		Movie result = db.getById(id);
		if(result==null){
			return Response.status(404).build();			
		}
		return Response.ok(result).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Movie m){
		Movie result = db.getById(id);
		if(result==null){
			return Response.status(404).build();
		}
		m.setId(id);
		db.update(m);
		return Response.ok().build();
	}
	
	/*@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Movie result = db.getById(id);
		if(result==null){
			return Response.status(404).build();
		}
		db.delete(result);
		return Response.ok().build();
	}*/
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Movie result = db.getById(id);
		if (result == null) {
			return Response.status(404).build();
		}
		db.delete(result);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/{movieId}/actors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getActors(@PathParam("movieId") int movieId){
		Movie result = db.getById(movieId);
		if(result==null){
			return null;		
		}
		return db.addActor(movieId);
	} 
	
	@DELETE
	@Path("/{id}/actors/{actorId}")
	public Response deleteActor(@PathParam("id") int movieId, @PathParam("actorId") int actorId) {
		Movie result = db.getById(actorId);
		if (result == null) {
			return Response.status(404).build();
		}
		db.deleteActor(result, movieId);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{movieId}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments(@PathParam("movieId") int movieId){
		Movie result = db.getById(movieId);
		if(result==null){
			return null;		
		}
		if(result.getComments()==null){
			result.setComments(new ArrayList<>());
		}
		return result.getComments();
	}
	
	@POST
	@Path("/{id}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("id") int MovieId, Comment comment){
		Movie result = db.getById(MovieId);
		if(result==null){
			return Response.status(404).build();		
		}
		if(result.getComments()==null){
			result.setComments(new ArrayList<>());
		}
		db.addComment(result, comment);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}/comments/{commentId}")
	public Response deleteComment(@PathParam("id") int movieId, @PathParam("commentId") int commentId) {
		Movie result = db.getById(movieId);
		if (result == null) {
			return Response.status(404).build();
		}
		db.deleteComment(result, commentId);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{movieId}/ratings")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rating> getRatings(@PathParam("movieId") int movieId) {
		Movie result = db.getById(movieId);
		if (result == null) {
			return null;
		}
		if (result.getRating() == null) {
			result.setRating(new ArrayList<>());
		}
		return result.getRating();
	}
	
	@POST
	@Path("/{id}/ratings")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRatings(@PathParam("id") int movieId, Rating rating) {
		Movie result = db.getById(movieId);
		if (result == null) {
			return Response.status(404).build();
		}
		if (result.getRating() == null) {
			result.setRating(new ArrayList<>());
		}
		db.addRating(result, rating);
		return Response.ok().build();
	}
}
