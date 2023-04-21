package training.utilities.json.gson.baeldung;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class ActorGsonDeserializer implements JsonDeserializer<ActorGson>
{
    private final SimpleDateFormat
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    
    @Override
    public ActorGson deserialize(JsonElement json, Type type,
                                 JsonDeserializationContext jsonDeserializationContext)
    {
        JsonObject jsonObject = json.getAsJsonObject();
        
        JsonElement jsonImdbId = jsonObject.get("imdbId");
        JsonElement jsonDateOfBirth = jsonObject.get("dateOfBirth");
        JsonArray jsonFilmography = jsonObject.getAsJsonArray("filmography");
        
        ArrayList<String> filmList = new ArrayList<>();
        if (jsonFilmography != null) {
            for (int i = 0; i < jsonFilmography.size(); i++) {
                filmList.add(jsonFilmography.get(i).getAsString());
            }
        }
    
        try
        {
            return new ActorGson(   jsonImdbId.getAsString(),
                                    DATE_FORMAT.parse(jsonDateOfBirth.getAsString()),
                                    filmList);
        }
        catch(ParseException e)
        {
            throw new RuntimeException(e);
        }
    }
}
