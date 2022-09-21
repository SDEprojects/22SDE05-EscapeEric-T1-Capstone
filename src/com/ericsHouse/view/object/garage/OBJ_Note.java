package com.ericsHouse.view.object.garage;

import com.ericsHouse.jsonParser.JsonParser;
import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.ericsHouse.view.GameFrame.sidePanel;


public class OBJ_Note extends SuperObject {

    public OBJ_Note(){
        name = "note";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/garage/garage_OBJ/note.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        solidArea = new Rectangle(0,0,16*2,16*2);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

    @Override
    public void  interact(int objIndex, GamePanel gp){
        //TODO - refactor this check so that it's not so hard coded
        List<SuperObject> hasGlasses = gp.player.getBackpack().stream().filter(obj -> obj.name.equals("glasses")).collect(Collectors.toList());
        if(gettable && hasGlasses.size() > 0){
            JsonParser.getPrompt(gp.obj[objIndex].name,gp);
            gp.player.addItem(gp.obj[objIndex]);
            sidePanel.inventorySetUp(gp.obj[objIndex]);
            //sidePanel.inventoryDisplay();
            gp.obj[objIndex] = null;

        }
        else{
            System.out.println("Even if you got the note, you couldn't read it\nNeed to find your glasses first.");
        }
    }
}
