package com.ericsHouse.view.util;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Music {
    public static Clip clip;
    public static FloatControl gainControl;
    public static ClassLoader classLoader;

    public static void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        classLoader = Thread.currentThread().getContextClassLoader();
        InputStream musicStream = classLoader.getResourceAsStream("sounds/8-Bit-Bop.wav");
        InputStream bufferedMusic = new BufferedInputStream(musicStream);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedMusic);
        try {
            if(clip.isActive()){
                clip.stop();
            }
        }catch (NullPointerException e){
            //Do nothing if no clip exists, proceed as usual
        }
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-15.0f);
        clip.start();
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    public static void stop() {
        //stops the current clip
        clip.stop();
    }
}
