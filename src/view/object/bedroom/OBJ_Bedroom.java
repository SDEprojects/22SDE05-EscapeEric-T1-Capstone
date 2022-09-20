package view.object.bedroom;

import com.ericsHouse.jsonParser.JsonParser;
import view.GamePanel;
import view.object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Bedroom extends SuperObject {
    public int width;
    public int height;

    public OBJ_Bedroom(String name, String file, int width, int height){
        this.name = name;
        this.width = width;
        this.height = height;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(file));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        solidArea = new Rectangle(0,0,width * 3,height * 3);
    }


    @Override
    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, screenX, screenY, width * 3, height * 3, null);

    }

    @Override
    public void interact(int objIndex, GamePanel gp){
        if(Objects.equals(gp.obj[objIndex].name, "door")){
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.doorParser(gp);
        } else if(this.riddleItem && !this.solved){
            gp.gameState = gp.riddleState;
            gp.ui.currentDialogue = JsonParser.riddleParser(gp.obj[objIndex].name,gp);
        }else if(this.riddleItem){
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.riddleAnswerParser(gp.obj[objIndex].name,"correctOut",gp);
        }
      else{
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = JsonParser.getPrompt(gp.obj[objIndex].name,gp);
        }
    }
}
