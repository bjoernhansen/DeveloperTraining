package training.utilities.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Main
{
    private static final SimpleDateFormat
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    private static final SimpleDateFormat
        dateFormatWithTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    
    public static void main(String[] args) throws ParseException, JsonProcessingException
    {
        // executeSerializationExamples();
        executeDeserializationExamples();
    }
    
    private static void executeSerializationExamples() throws ParseException, JsonProcessingException
    {
        ActorJackson newActor = new ActorJackson(
            "nm2199632",
            dateFormat.parse("21-09-1982"),
            Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
    
        Movie movie = new Movie("tt0472043", "Mel Gibson", List.of(newActor));
        ObjectMapper mapper = new ObjectMapper();
        String jsonResultOne = mapper.writerWithDefaultPrettyPrinter()
                                     .writeValueAsString(movie);
        System.out.println(jsonResultOne);
    
    
        MovieWithNullValue movieWithNullValue = new MovieWithNullValue(null, "Mel Gibson", List.of(newActor));
    
        SimpleModule module = new SimpleModule();
        module.addSerializer(new ActorJacksonSerializer(ActorJackson.class));
        ObjectMapper customMapper = new ObjectMapper();
        String jsonResultTwo = customMapper.registerModule(module)
                                           .writer(new DefaultPrettyPrinter())
                                           .writeValueAsString(movieWithNullValue);
        System.out.println(jsonResultTwo);
    }
    
    private static void executeDeserializationExamples() throws JsonProcessingException
    {
        String jsonInput = "{\"imdbId\":\"tt0472043\",\"actors\":" +
            "[{\"imdbId\":\"nm2199632\",\"dateOfBirth\":\"1982-09-21T12:00:00+01:00\"," +
            "\"filmography\":[\"Apocalypto\",\"Beatdown\",\"Wind Walkers\"]}]}";
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormatWithTime);
        Movie movie = mapper.readValue(jsonInput, Movie.class);
        System.out.println(movie);
    }
}
