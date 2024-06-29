package training.basics.stream;

import training.basics.stream.example_models.FliegendeUntertasse;
import training.basics.stream.example_models.Flugzeug;
import training.basics.stream.example_models.FlyingObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import static java.util.stream.Collectors.joining;


class ObjectStreamExample
{
    public static void main(String[] args)
    {
        List<FlyingObject> flyingObjects = List.of(new FliegendeUntertasse(), new Flugzeug(), new Flugzeug());
        String flyingObjectsSimpleClassNames = flyingObjects.stream()
                                                            .map(Object::getClass)
                                                            .map(Class::getSimpleName)
                                                            .collect(joining(", "));
        System.out.println("Einzulesende Instanzen: " + flyingObjectsSimpleClassNames);
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("logs/objectStream")))
        {
            for(FlyingObject flyingObject : flyingObjects)
            {
                oos.writeObject(flyingObject);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        // Lesen des Objekts aus einem Stream
        System.out.println("Ausgelesene Instanzen: ");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("logs/objectStream")))
        {
            while (true) {
                try {
                    FlyingObject readObject = (FlyingObject) ois.readObject();
                    System.out.println("Gelesenes Objekt: " + readObject.getClass().getSimpleName());
                } catch (IOException e) {
                    if (e instanceof java.io.EOFException) {
                        break; // Ende des Streams erreicht
                    }
                    e.printStackTrace();
                }
            }
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}