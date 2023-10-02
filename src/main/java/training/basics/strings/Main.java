package training.basics.strings;

import training.utilities.Stopwatch;


public class Main {

    private static final int NUMBER_OF_RUNS = 1000000;

    public static void main(String[] args) {
        String fileName = "16_oder_Gel_baec5ca1d0bb4ca1ca69c7499eae8f43_old_1084691.pdf";


        Stopwatch stopwatch = Stopwatch.withMillisecondPrecision();

        System.out.println("Vortest");
        stopwatch.startClock();
        for(int i = 0; i < NUMBER_OF_RUNS; i++){
            NumberFromStringExtractor.getSapidFromFilenameBjoern(fileName);
        }
        stopwatch.stopClock();


        System.out.println("Jannes");
        stopwatch.startClock();
        for(int i = 0; i < NUMBER_OF_RUNS; i++){
            NumberFromStringExtractor.getSapidFromFilenameJannes(fileName);
        }
        stopwatch.stopClock();
        if(NumberFromStringExtractor.getSapidFromFilenameJannes(fileName).equals("1084691")){
            System.out.println("RICHTIG");
        }
        else {
            System.out.println("FALSCH: " + NumberFromStringExtractor.getSapidFromFilenameJannes(fileName));
        }

        System.out.println("Bjoern");
        stopwatch.startClock();
        for(int i = 0; i < NUMBER_OF_RUNS; i++){
            NumberFromStringExtractor.getSapidFromFilenameBjoern(fileName);
        }
        stopwatch.stopClock();
        if(NumberFromStringExtractor.getSapidFromFilenameBjoern(fileName).equals("1084691")){
            System.out.println("RICHTIG: " + NumberFromStringExtractor.getSapidFromFilenameBjoern(fileName));
        }
        else {
            System.out.println("FALSCH: " + NumberFromStringExtractor.getSapidFromFilenameBjoern(fileName));
        }

        System.out.println("Sven");
        stopwatch.startClock();
        for(int i = 0; i < NUMBER_OF_RUNS; i++){
            NumberFromStringExtractor.getSapidFromFilenameSven(fileName);
        }
        stopwatch.stopClock();
        if(NumberFromStringExtractor.getSapidFromFilenameSven(fileName).equals("1084691")){
            System.out.println("RICHTIG: " + NumberFromStringExtractor.getSapidFromFilenameSven(fileName));
        }
        else {
            System.out.println("FALSCH: " + NumberFromStringExtractor.getSapidFromFilenameSven(fileName));
        }

        System.out.println("Uwe");
        stopwatch.startClock();
        for(int i = 0; i < NUMBER_OF_RUNS; i++){
            NumberFromStringExtractor.getSapidFromFilenameUwe(fileName);
        }
        stopwatch.stopClock();
        if(NumberFromStringExtractor.getSapidFromFilenameUwe(fileName).equals("1084691")){
            System.out.println("RICHTIG");
        }
        else {
            System.out.println("FALSCH: " + NumberFromStringExtractor.getSapidFromFilenameUwe(fileName));
        }



        // System.out.println("Sapid: " + sapid);
    }
}
