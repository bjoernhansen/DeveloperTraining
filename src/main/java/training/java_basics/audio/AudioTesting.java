package training.java_basics.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class AudioTesting
{
    private static final String
        SOUND_PATH = "src/main/resources/sounds/announcer_bonus_credit.wav";
    
    
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException
    {
        AudioTesting audioTesting = new AudioTesting();
        audioTesting.playSound();
    }
    
    void playSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException
    {
        File file = new File(SOUND_PATH);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(2);
        Thread.sleep(5000);
    }
}
