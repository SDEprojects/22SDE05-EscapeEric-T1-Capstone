package com.ericsHouse.view.object.living_room;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.util.WordOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.ericsHouse.view.panels.GamePanel.currentRoom;

public class OBJ_Dog extends SuperObject {
    public int width;
    public int height;
    public static WordOrder wo;

    public OBJ_Dog(String name, String file, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0, 0, width * 5, height * 5);
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);

    }

    @Override
    public void interact(String objIndex, GamePanel gp) throws JsonProcessingException {
        int itemCount = 0;
        for(SuperObject obj:gp.player.getBackpack()){
            if(obj.name.equals("pears") || obj.name.equals( "oranges") || obj.name.equals("note") || obj.name.equals("emerald-earrings")){
                itemCount++;
            }
        }
        if(itemCount == 4){
            gp.gameState = gp.wordOrder;
            gp.ui.currentDialogue = JsonParser.getPrompt(currentRoom.mapObjects.get(objIndex).name, gp);
            wo = new WordOrder(gp);
        }else{
            gp.ui.currentDialogue = "The dog gives you a look that makes you feel like\nyou may not have all the items you need.\nTry looking in the living-room and kitchen for the items.";
            gp.gameState = gp.dialogueState;
        }
        System.out.println(gp.player.getBackpack());
    }
}
