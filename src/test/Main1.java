package test;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.Movie;

public class Main1 {
	
	public static void main(String[] args) {
		Movie m = new Movie();
		m.setImdbID("tt0016367");
		m.setTitle("From dusk till dawn");
		m.setReleaseYear(1996);
		m.setRating(7.2);
		String[] actors = {"George Clooney", "Quentin Tarantino"};
		m.setActors(actors);
		
		System.out.println(m);
		
		try(FileWriter fw = new FileWriter("movie.json")){
			
			//Gson gson = new Gson();
			Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
			//String json = gson.toJson(m);
			//System.out.println(json);
			gson.toJson(m, fw);
			//fw.write(json);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
