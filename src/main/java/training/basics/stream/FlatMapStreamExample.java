package training.basics.stream;

import training.basics.stream.example_models.FliegendeUntertasse;
import training.basics.stream.example_models.Flugzeug;
import training.basics.stream.example_models.FlyingObject;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;


class FlatMapStreamExample
{
    public static void main(String[] args)
    {
        var plane1 = new Flugzeug();
        var plane2 = new Flugzeug();
        var ufo = new FliegendeUntertasse();
        
        List<FlyingObject> liste1 = List.of(plane1, plane2);
        List<FlyingObject> liste2 = List.of(plane1, ufo);
        List<FlyingObject> liste3 = List.of(plane2, ufo);
        
        Stream.of(liste1, liste2, liste3)
              .flatMap(Collection::stream)
              .distinct()
              .forEach(System.out::println);
    }
}
