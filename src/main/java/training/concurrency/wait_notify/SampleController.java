package training.concurrency.wait_notify;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

/**
 * Monitor: -> Schranke, an der andere Threads Warten können -> bezieht sich auf
 * ein synchronized-Block oder eine synchronized Methode -> beinhaltet Daten,
 * die zu schützen sind
 * 
 * @author micha
 */

public class SampleController
{

    public static long count;

    private static final int MAX = 100000000;
    @FXML
    private ProgressIndicator progress1;
    @FXML
    private ProgressIndicator progress2;

    @FXML
    Label label1;
    @FXML
    Label label2;

    private final Object lockObjekt = new Object(); // jedes Java-Object hat die
                                              // Eigenschaften eines Monitors
                                              // (LockObjekt),
                                              // kann also für
                                              // synchronized-Block verwendet
                                              // werden

    // Event Listener on Button.onAction
    @FXML
    public void start1()
    {        
        Task<Long> task1 = createTask1();
        Thread t1 = new Thread(task1);
        t1.setDaemon(true);
        t1.start();
        progress1.progressProperty().bind(task1.progressProperty());
        label1.textProperty().bind(task1.valueProperty().asString());

        Task<Long> task2 = createTask2();
        Thread t2 = new Thread(task2);
        t2.setDaemon(true);
        t2.start();
        progress2.progressProperty().bind(task2.progressProperty());
        label2.textProperty().bind(task2.valueProperty().asString());
    }

    public Task<Long> createTask1()
    {
        return new Task<>()
        {
            @Override
            protected Long call() throws Exception
            {
                for(int i = 1; i <= MAX; i++)
                {
                    updateProgress(i, MAX);
                    count++;
                    updateValue(count);
    
                    // System.out.println(count);
                    if(count == MAX / 4)
                    {
                        synchronized(lockObjekt)
                        {
                            lockObjekt.notify();// anderen Thread aufwecken
                            lockObjekt.wait(); // selber schlafen legen
                        }
                    }
                    else if(i == MAX)
                    {
                        synchronized(lockObjekt)
                        {
                            lockObjekt.notify();// anderen Thread aufwecken
                            lockObjekt.wait(); // selber schlafen legen
                        }
                    }
                }
                return count;
            }
        };
    }

    public Task<Long> createTask2()
    {
        return new Task<>()
        {
            @Override
            protected Long call() throws Exception
            {
                updateValue(0L);
                updateProgress(0, MAX);
                synchronized(lockObjekt)
                {
                    lockObjekt.wait();
                }
                for(int i = 1; i <= MAX; i++)
                {
                    updateProgress(i, MAX);
                    count++;
                    updateValue(count);
    
                    if(count == MAX / 1.33F)
                    {
                        synchronized(lockObjekt)
                        {
                            lockObjekt.notify();
                            lockObjekt.wait();
                        }
                    }
                }
                return count;
            }
        };
    }
}
