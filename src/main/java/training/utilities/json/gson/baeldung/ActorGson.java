package training.utilities.json.gson.baeldung;

import java.util.Date;
import java.util.List;


class ActorGson
{
    private String imdbId;
    private Date dateOfBirth;
    private List<String> filmography;
    
    
    public ActorGson(String imdbId, Date dateOfBirth, List<String> filmography)
    {
        this.imdbId = imdbId;
        this.dateOfBirth = dateOfBirth;
        this.filmography = filmography;
    }
    
    public String getImdbId()
    {
        return imdbId;
    }
    
    public void setImdbId(String imdbId)
    {
        this.imdbId = imdbId;
    }
    
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    
    public List<String> getFilmography()
    {
        return filmography;
    }
    
    public void setFilmography(List<String> filmography)
    {
        this.filmography = filmography;
    }
    
    @Override
    public String toString() {
        return "ActorGson [imdbId=" + imdbId + ", dateOfBirth=" + dateOfBirth +
            ",filmography=" + filmography + "]";
    }
}
