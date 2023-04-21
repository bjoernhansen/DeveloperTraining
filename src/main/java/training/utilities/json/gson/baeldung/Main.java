package training.utilities.json.gson.baeldung;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

class Main
{
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    
    public static void main(String[] args) throws ParseException
    {
        executeSerializationExamples();
        executeDeserializationExamples();
    }
    
    private static void executeSerializationExamples() throws ParseException
    {
        ActorGson youngActor = new ActorGson("nm2199632", DATE_FORMAT.parse("21-09-1982"), Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
        
        // first example
        Movie movie = new Movie("tt0472043", "<Mel Gibson>", List.of(youngActor));
        String serializedMovieOne = makePrettyPrintingGson().toJson(movie);
        System.out.println(serializedMovieOne + "\n");
        
        // second example
        MovieWithNullValue movieWithNullValue = new MovieWithNullValue(null, "Mel Gibson", List.of(youngActor));
        String serializedMovieTwo = makeCustomGson().toJson(movieWithNullValue);
        System.out.println(serializedMovieTwo);
    }
    
    private static Gson makePrettyPrintingGson()
    {
        return new GsonBuilder().setPrettyPrinting()
                                .disableHtmlEscaping()  // Zeichen wie "<" und ">" werden nicht Escaped
                                .create();
    }
    
    private static Gson makeCustomGson()
    {
        return new GsonBuilder().setPrettyPrinting()
                                .excludeFieldsWithoutExposeAnnotation()
                                .serializeNulls()
                                .disableHtmlEscaping()
                                .registerTypeAdapter(ActorGson.class, new ActorGsonSerializer())
                                .create();
    }
    
    private static void executeDeserializationExamples()
    {
        String jsonInput = "{\"imdbId\":\"tt0472043\",\"actors\":" +
            "[{\"imdbId\":\"nm2199632\",\"dateOfBirth\":\"1982-09-21T12:00:00+01:00\"," +
            "\"filmography\":[\"Apocalypto\",\"Beatdown\",\"Wind Walkers\"]}]}";
        
        // example one
        Movie outputMovieOne = new Gson().fromJson(jsonInput, Movie.class);
        System.out.println(outputMovieOne);
        
        // example two
    
        Movie outputMovieTwo = makeCustomGsonForDeserialization().fromJson(jsonInput, Movie.class);
        System.out.println(outputMovieTwo);
    }
    
    private static Gson makeCustomGsonForDeserialization()
    {
        return new GsonBuilder()
            .registerTypeAdapter(ActorGson.class, new ActorGsonDeserializer())
            .create();
    }
}
