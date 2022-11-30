package training.javafx.games.jumping_in_the_forest;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


class Voice
{    
    private static final String     
        JUMP_1_SOUND_PATH = "sounds/jump_1.mp3",
        JUMP_2_SOUND_PATH = "sounds/jump_2.mp3";
        
    private final MediaPlayer
        jump_1_sound,
        jump_2_sound;

    
    Voice()
    {
        this.jump_1_sound = new MediaPlayer(new Media(fromUrlOf(JUMP_1_SOUND_PATH)));
        this.jump_2_sound = new MediaPlayer(new Media(fromUrlOf(JUMP_2_SOUND_PATH)));
    }
    
    void shoutJump()
    {
        this.jump_1_sound.stop();
        this.jump_2_sound.stop();
        this.jump_1_sound.play();
    }
    
    void shoutSomersault()
    {
        this.jump_1_sound.stop();
        this.jump_2_sound.stop();
        this.jump_2_sound.play();
    }
    
    private String fromUrlOf(String path)
    {
        return getClass().getResource(path).toString();
    }
}