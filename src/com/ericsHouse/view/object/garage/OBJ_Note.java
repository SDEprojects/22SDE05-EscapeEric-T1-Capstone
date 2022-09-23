package com.ericsHouse.view.object.garage;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.ericsHouse.view.util.GameFrame.sidePanel;
import static com.ericsHouse.view.panels.GamePanel.currentRoom;


public class OBJ_Note extends SuperObject {
    public OBJ_Note() {
        name = "note";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/note.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        solidArea = new Rectangle(0, 0, 16 * 2, 16 * 2);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        //TODO - refactor this check so that it's not so hard coded
        List<SuperObject> hasGlasses = gp.player.getBackpack().stream().filter(obj -> obj.name.equals("glasses")).collect(Collectors.toList());
        if (gettable && hasGlasses.size() > 0) {
            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            gp.player.addItem(currentRoom.mapObjects.get(objIndex));
            sidePanel.inventorySetUp(currentRoom.mapObjects.get(objIndex));
            currentRoom.mapObjects.remove(objIndex);
            gp.gameState = gp.dialogueState;
        }
            else {
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You look at the note and it's a blur...\nNeed to find your glasses first.\nI bet Eric hid them somewhere, sneaky dude.\nTry using 'E' next to any item to search for 'em.";
            //System.out.println("Even if you got the note, you couldn't read it\nNeed to find your glasses first.");
        }
    }
}
