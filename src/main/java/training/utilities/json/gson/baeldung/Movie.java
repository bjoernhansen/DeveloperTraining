package training.utilities.json.gson.baeldung;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class Movie
{
    private String imdbId;
    @SerializedName("Direktor")
    private String director;
    private List<ActorGson> actors;
    
    
    public Movie(String imdbId, String director, List<ActorGson> actors)
    {
        this.imdbId = imdbId;
        this.director = director;
        this.actors = actors;
    }
    
    public String getImdbId()
    {
        return imdbId;
    }
    
    public void setImdbId(String imdbId)
    {
        this.imdbId = imdbId;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public void setDirector(String director)
    {
        this.director = director;
    }
    
    public List<ActorGson> getActors()
    {
        return actors;
    }
    
    public void setActors(List<ActorGson> actors)
    {
        this.actors = actors;
    }
    
    @Override
    public String toString() {
        return "Movie [imdbId=" + imdbId + ", director=" + director + ",actors=" + actors + "]";
    }
}
