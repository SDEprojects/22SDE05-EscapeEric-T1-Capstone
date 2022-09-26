package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.entity.Player;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.Riddle;
import com.ericsHouse.view.util.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static com.ericsHouse.view.util.GameFrame.sidePanel;
import static com.ericsHouse.view.panels.GamePanel.currentRoom;


public class OBJ_Kitchen extends SuperObject {
    public int width;
    public int height;

    public OBJ_Kitchen(String name, String file, int width, int height) {
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
        boolean hasKnife = false;
        for (SuperObject item : gp.player.getBackpack()) {
            if (item.name == "knife") {
                hasKnife = true;
            }
        }
        if (gettable) {
            JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
            Player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
        } else if (Objects.equals(currentRoom.mapObjects.get(objIndex).name, "door")) {
            if (hasKnife) {
                GamePanel.gameState = GamePanel.dialogueState;
                UI.currentDialogue = JsonParser.doorUnlockedParser();
                try {
                    currentRoom.mapObjects.get("door").image = ImageIO.read(Riddle.class.getResourceAsStream("/rooms/kitchen/kitchen_OBJ/door-open.png"));
                    currentRoom.mapObjects.get("door").collision = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                UI.currentDialogue = JsonParser.doorParser();
                GamePanel.gameState = GamePanel.dialogueState;
            }
        } else {
            GamePanel.gameState = GamePanel.dialogueState;
            UI.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name);
        }
    }
}
