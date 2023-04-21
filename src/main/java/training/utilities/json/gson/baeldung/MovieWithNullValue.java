package training.utilities.json.gson.baeldung;

import com.google.gson.annotations.Expose;

import java.util.List;


public class MovieWithNullValue
{
    @Expose
    private String imdbId;
    private String director;
    
    @Expose
    private List<ActorGson> actors;
    
    public MovieWithNullValue(String imdbId, String director, List<ActorGson> actors)
    {
        this.imdbId = imdbId;
        this.director = director;
        this.actors = actors;
    }
}
