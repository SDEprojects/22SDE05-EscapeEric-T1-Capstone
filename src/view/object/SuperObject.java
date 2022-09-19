package view.object;

import com.ericsHouse.jsonParser.JsonParser;
import view.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {


    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int screenX, screenY;
    //You may need to change this for the different objects, this is only one tile worth of area
    public Rectangle solidArea = new Rectangle(0, 0, 48 * 2, 48 * 2);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public boolean gettable = false;

    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2, null);

    }

    public void interact(int objIndex, GamePanel gp) {
        if (gettable) {
            //If object is gettable, display dialogue box
            //If user selects get item then the object is put in their inventory
            JsonParser.getPrompt(gp.obj[objIndex].name);
            gp.player.addItem(gp.obj[objIndex]);
            gp.obj[objIndex] = null;
        }
        //If item isn't gettable display dialogue box with description
        else {
            //gp.gameState = gp.dialogueState;
            JsonParser.getPrompt(gp.obj[objIndex].name);
        }
    }
}
