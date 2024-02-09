package training.concurrency;

import java.util.*;

public class WorkingWithThreads
{
    private static final int MAX_NUMBER_OF_THREADS = 5;
    static final int DISTANCE = 3;

    public static void main(String[] args) {

        VariableNumber variableNumber = new VariableNumber();
        Deque<CustomThread> threads = new LinkedList<>();

        if(MAX_NUMBER_OF_THREADS > 0)
        {
            threads.addLast(new CustomThread(0, variableNumber, 0, 2 * DISTANCE));
        }
        for(int i = 0; i < MAX_NUMBER_OF_THREADS - 1; i++)
        {
            CustomThread nextThread = new CustomThread(i + 1, variableNumber, DISTANCE * i, DISTANCE * i + 3 * DISTANCE);
            threads.addLast(nextThread);
        }
        threads.getLast().setUnpausable();
        System.out.println("Highes Value:" +  (threads.getLast().getRangeOfResponsibility().getLowerBound()+1) + "\n");

        threads.forEach(Thread::start);

        threads.forEach(thread ->
        {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("*** ENDE DES HAUPTPROGRAMMS ***");
    }
}
