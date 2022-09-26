package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

        g2.drawImage(image, screenX, screenY, GamePanel.tileSize * 2, GamePanel.tileSize * 2 + 5, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        List<SuperObject> hasNote = gp.player.getBackpack().stream().filter(obj -> obj.name.equals("note")).collect(Collectors.toList());
            if (hasNote.size() > 0){
            UI.currentDialogue = "You open the door and get ready to solve some puzzles!!\nLet's escape Eric's house";
            currentRoom.mapObjects.remove(objIndex);
            } else {
            UI.currentDialogue = "You hear Shaq's voice...\n'HEY get that note first.\nIt's important you know what's going on.'\n";
            }
        GamePanel.gameState = GamePanel.dialogueState;
    }
}
