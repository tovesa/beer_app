package es.test.client;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DataStorageClient {
	public void start();

	public void stop();

	public void createBeerRating(BeerRating beerRating) throws JsonProcessingException;

	public String getAutoSuggestions(String searchField, String searchTerm);

	public List<BeerRating> getBeerRatings(String searchField, String searchTerm);
}
