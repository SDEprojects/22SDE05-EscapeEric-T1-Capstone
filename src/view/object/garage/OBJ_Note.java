package view.object.garage;

import view.GamePanel;
import view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Note extends SuperObject {

    public OBJ_Note(){
        name = "note";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/note.png"));
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
}
