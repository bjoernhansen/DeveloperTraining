package training.utilities;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class ReadURL {

    private ReadURL(){}


    private static final String URL = "http://tutego.de/aufgaben/bond.txt";

    static void printURLContent() {
        Scanner scanner = null;
        try {
            scanner = new Scanner( new URL(URL).openStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = Objects.requireNonNull(scanner)
                                .useDelimiter("\\z" ).next();
        System.out.println(content);
    }
    
    public static void main(String[] args)
    {
        printURLContent();
    }
}