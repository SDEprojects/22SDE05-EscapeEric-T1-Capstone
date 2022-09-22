package com.ericsHouse.view.util;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;
import static com.ericsHouse.view.util.KeyHandler.objIndex;

public class Riddle {

    public static int riddleCount = 0;
    public static boolean riddleCorrect = false;


    public static void checkRiddle(GamePanel gp) {

        int riddleAnswer = Integer.parseInt(JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "correct", gp));
        if (gp.subState == riddleAnswer) {
            riddleCorrect = true;
            riddleCount++;
            if (riddleCount == 3) {
                currentRoom.mapObjects.get("door").collision = false;
                try {
                    currentRoom.mapObjects.get("door").image = ImageIO.read(Riddle.class.getResourceAsStream("/rooms/bedroom/bedroom_OBJ/door-open.png"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

