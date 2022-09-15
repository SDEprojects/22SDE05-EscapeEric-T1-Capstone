package view;

import view.object.*;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new OBJ_Dresser();
        //Y moves object up and down
        gp.obj[0].screenY = 16;
        //X moves object left and right
        gp.obj[0].screenX = 48;

        gp.obj[1] = new OBJ_Dresser();
        //Y moves object up and down
        gp.obj[1].screenY = 16;
        //X moves object left and right
        gp.obj[1].screenX = 139;

        gp.obj[2] = new OBJ_Dresser();
        //Y moves object up and down
        gp.obj[2].screenY = 16;
        //X moves object left and right
        gp.obj[2].screenX = 230;

        gp.obj[3] = new OBJ_Frog();
        gp.obj[3].screenY = -15;
        gp.obj[3].screenX = 145;

        gp.obj[4] = new OBJ_Curtains();
        gp.obj[4].screenY = 4;
        gp.obj[4].screenX = 400;

        gp.obj[5] = new OBJ_Note();
        gp.obj[5].screenY = 400;
        gp.obj[5].screenX = 100;

        gp.obj[6] = new OBJ_Poster();
        gp.obj[6].screenY = 20;
        gp.obj[6].screenX = 570;

        gp.obj[7] = new OBJ_Car();
        gp.obj[7].screenY = 100;
        gp.obj[7].screenX = 300;

        gp.obj[8] = new OBJ_Door();
        gp.obj[8].screenY = 144;
        gp.obj[8].screenX = 0;

    }

    //Check if getPressed is checked
    //TODO Check if player is close to the object and determine the output based on the object
    public void update(){
        if (gp.keyH.getPressed){
            gp.obj[8] = null;
        }
    }
}
