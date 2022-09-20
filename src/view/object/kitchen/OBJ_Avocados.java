package view.object.kitchen;

import com.ericsHouse.jsonParser.JsonParser;
import view.GamePanel;
import view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Avocados extends SuperObject {
    public OBJ_Avocados() {
        name = "avocados";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/avocados.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        solidArea = new Rectangle(0, 0, 85 * 3, 46 * 3);
        gettable = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, screenX, screenY,gp.tileSize, gp.tileSize, null);
    }

    @Override
    public void  interact(int objIndex, GamePanel gp){
        if(gettable){
            //If object is gettable, display dialogue box
            //If user selects get item then the object is put in their inventory
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/rooms/kitchen/kitchen_OBJ/avocados.png"));
            }catch (IOException e){

            }
            gp.player.addItem(gp.obj[objIndex]);
            System.out.println(gp.player.getBackpack().size());
            JsonParser.getPrompt(gp.obj[objIndex].name,gp);
            gp.obj[objIndex] = null;
        }
    }
}
