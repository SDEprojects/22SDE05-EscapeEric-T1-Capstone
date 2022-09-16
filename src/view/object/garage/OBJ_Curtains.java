package view.object.garage;

import view.GamePanel;
import view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Curtains extends SuperObject {

    public OBJ_Curtains(){
        name = "curtains";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage/garage_OBJ/curtains.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, gp.tileSize * 3, gp.tileSize * 2, null);

    }
}
