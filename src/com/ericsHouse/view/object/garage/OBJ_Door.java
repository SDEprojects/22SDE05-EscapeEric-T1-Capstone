package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

public class OBJ_Door extends SuperObject {
    public OBJ_Door() {
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/garage-door-closed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0, 0, 16, 48 * 2);
        //This is the dirty way to remove the door, there should be a method called for door interaction
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2 + 5, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        //TODO - refactor this check so that it's not so hard coded
        if (gp.player.getBackpack().size() == 2) {
            gp.ui.currentDialogue = "You open the door and get ready to solve some puzzles!!\nLet's escape Eric's house";
            currentRoom.mapObjects.remove(objIndex);
            gp.gameState = gp.dialogueState;
        } else {
            gp.ui.currentDialogue = "You hear Shaq's voice...\n'HEY get that note first.\nIt's important you know what's going on.'\n";
            gp.gameState = gp.dialogueState;
        }
    }
}
