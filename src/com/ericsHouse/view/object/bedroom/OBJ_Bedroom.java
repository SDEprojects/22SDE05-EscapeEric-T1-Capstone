package com.ericsHouse.view.object.bedroom;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

public class OBJ_Bedroom extends SuperObject {
    public int width;
    public int height;

    public OBJ_Bedroom(String name, String file, int width, int height) {
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
        if (Objects.equals(currentRoom.mapObjects.get(objIndex).name, "door")) {
            GamePanel.gameState = GamePanel.dialogueState;
            UI.currentDialogue = JsonParser.doorParser();
        } else if (this.riddleItem && !this.solved) {
            GamePanel.gameState = gp.riddleState;
            UI.currentDialogue = JsonParser.riddleParser(currentRoom.mapObjects.get(objIndex).name);
        } else if (this.riddleItem) {
            GamePanel.gameState = GamePanel.dialogueState;
            UI.currentDialogue = JsonParser.riddleAnswerParser(currentRoom.mapObjects.get(objIndex).name, "correctOut", gp);
        } else {
            GamePanel.gameState = GamePanel.dialogueState;
            UI.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
        }
    }
}
