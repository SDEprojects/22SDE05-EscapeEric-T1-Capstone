package view.object;

import view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Curtains extends SuperObject{

    public OBJ_Curtains(){
        name = "curtains";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/garage_OBJ/curtains.png"));
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
