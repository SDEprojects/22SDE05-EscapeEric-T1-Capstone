package com.ericsHouse.view.object.bathroom;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

public class OBJ_Bathroom extends SuperObject {
    public int width;
    public int height;

    public OBJ_Bathroom(String name, String file, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0, 0, width * 3, height * 3);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);
    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        if (Objects.equals(currentRoom.mapObjects.get(objIndex).name, "david-mirror") && !win) {
            GamePanel.gameState = GamePanel.dialogueState;
            UI.currentDialogue = JsonParser.RockPaperScissors();
            GamePanel.gameState = gp.rockPaperScissors;
        } else if (win) {
            UI.currentDialogue = "You've already beat your mirror reflection.";
            GamePanel.gameState = GamePanel.dialogueState;
        } else {
            try{
                UI.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
                GamePanel.gameState = GamePanel.dialogueState;
            }
            catch (NullPointerException ex){
                ex.printStackTrace();
            }
        }
    }
}
