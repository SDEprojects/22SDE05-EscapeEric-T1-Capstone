package com.ericsHouse.view.object.garage;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

public class OBJ_WorkBench extends SuperObject {
    public OBJ_WorkBench(){
        name = "workbench";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/workbench.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        solidArea = new Rectangle(0, 0, 22 * 3, 29 * 3);
        collision = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, 22 * 3, 29 * 3, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) {
        boolean hasHammer = false;
        for(SuperObject obj: gp.player.getBackpack()){
            if(obj.name.equals("hammer")){
                hasHammer = true;
            }
        }

        if (hasHammer) {
            gp.ui.currentDialogue = "To build a new item:\n1.Click on the hammer.\n2. Click the item you would like to craft.\n";
            gp.gameState = gp.craftState;
        }else{
            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            gp.gameState = gp.dialogueState;
        }
    }
}
