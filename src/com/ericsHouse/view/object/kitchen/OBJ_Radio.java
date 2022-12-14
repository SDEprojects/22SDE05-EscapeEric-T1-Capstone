package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.Music;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class OBJ_Radio extends SuperObject {

    private boolean musicPlaying = false;

    public OBJ_Radio() {
        name = "radio";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/radio.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(10, -18, 16 * 3, 22 * 3);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, 16 * 3, 16 * 3, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        try {
            if (musicPlaying) {
                Music.stop();
                musicPlaying = false;
            } else {
                Music.play();
                musicPlaying = true;
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }
}
