package training.javafx.animation;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GrowingNumber extends Application
{
    // main timeline
    private Timeline timeline;
    private AnimationTimer timer;

    // variable for storing actual frame
    Integer i = 0;

    @Override
    public void start(Stage stage)
    {
        Group p = new Group();
        Scene scene = new Scene(p);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        p.setTranslateX(80);
        p.setTranslateY(80);

        // create a circle with effect
        final Circle circle = new Circle(20, Color.rgb(156, 216, 255));
        circle.setEffect(new Lighting());
        // create a text inside a circle
        final Text text = new Text(this.i.toString());
        text.setStroke(Color.BLACK);
        // create a layout for circle with text inside
        final StackPane stack = new StackPane();
        stack.getChildren().addAll(circle, text);
        stack.setLayoutX(30);
        stack.setLayoutY(30);

        p.getChildren().add(stack);
        stage.show();

        // create a timeline for moving the circle
        this.timeline = new Timeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.setAutoReverse(true);

        // You can add a specific action when each frame is started.
        this.timer = new AnimationTimer()
        {
            @Override
            public void handle(long l)
            {
                text.setText(GrowingNumber.this.i.toString());
                GrowingNumber.this.i++;
            }
        };

        // create a keyValue with factory: scaling the circle 2times
        KeyValue keyValueX = new KeyValue(stack.scaleXProperty(), 2);
        KeyValue keyValueY = new KeyValue(stack.scaleYProperty(), 2);

        // create a keyFrame, the keyValue is reached at time 2s
        Duration duration = Duration.millis(2000);
        // one can add a specific action when the keyframe is reached
        EventHandler<ActionEvent> onFinished = t -> {
            stack.setTranslateX(Math.random() * 200 - 100);
            // reset counter
            GrowingNumber.this.i = 0;
        };

        KeyFrame keyFrame = new KeyFrame(duration, onFinished, keyValueX,
                keyValueY);

        // add the keyframe to the timeline
        this.timeline.getKeyFrames().add(keyFrame);

        this.timeline.play();
        this.timer.start();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}