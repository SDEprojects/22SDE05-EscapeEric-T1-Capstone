package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;

import java.util.Arrays;

public class KitchenAssetSetter extends AssetSetter {
    public KitchenAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject(){
        //TODO put all the object instantiation information in a txt or json file and parse it and
        //Resetting the obj array for the kitchen objects to be drawn in the room
        Arrays.fill(gp.obj, null);
        gp.obj = new SuperObject[30];

        //Setting all objects in the kitchen
        gp.obj[0] = new OBJ_Fridge();
        gp.obj[0].screenX = 11 * 3;
        gp.obj[0].screenY = 36 ;

        gp.obj[1] = new OBJ_Cabinet();
        gp.obj[1].screenX = 31 * 3;
        gp.obj[1].screenY = 0 ;

        gp.obj[2] = new OBJ_Hutch();
        gp.obj[2].screenX = 61 * 3;
        gp.obj[2].screenY = 36;

        gp.obj[3] = new OBJ_Sink();
        gp.obj[3].screenX = 82 * 3;
        gp.obj[3].screenY = 0 ;

        gp.obj[4] = new OBJ_Oven();
        gp.obj[4].screenX = 142 * 3;
        gp.obj[4].screenY = 15;

        gp.obj[5] = new OBJ_Kitchen("hutch", "/rooms/kitchen/kitchen_OBJ/hutch.png",22,34);
        gp.obj[5].screenX = 175 * 3;
        gp.obj[5].screenY = 36;

        gp.obj[7] = new OBJ_Kitchen("door", "/rooms/kitchen/kitchen_OBJ/door.png", 26,30);
        gp.obj[7].screenX = 205 * 3;
        gp.obj[7].screenY = 10;

        gp.obj[8] = new OBJ_Kitchen("house-plant", "/rooms/kitchen/kitchen_OBJ/house-plant.png", 18,28);
        gp.obj[8].screenX = 229 * 3;
        gp.obj[8].screenY = 36;

        gp.obj[9] = new OBJ_Kitchen("cat-pic", "/rooms/kitchen/kitchen_OBJ/cat-pic.png", 16  ,16);
        gp.obj[9].screenX = 65 * 3;
        gp.obj[9].screenY = -10;

        gp.obj[10] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        gp.obj[10].screenX = 47 * 3;
        gp.obj[10].screenY = 62 * 3;

        gp.obj[11] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island2.png", 16  ,16);
        gp.obj[11].screenX = 62 * 3;
        gp.obj[11].screenY = 62 * 3;

        gp.obj[12] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island3.png", 16  ,16);
        gp.obj[12].screenX = 62 * 3;
        gp.obj[12].screenY = 75 * 3;

        gp.obj[13] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island4.png", 16  ,16);
        gp.obj[13].screenX = 78 * 3;
        gp.obj[13].screenY = 75 * 3;

        gp.obj[14] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island5.png", 16  ,16);
        gp.obj[14].screenX = 78 * 3;
        gp.obj[14].screenY = 90 * 3;

        gp.obj[15] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island6.png", 16  ,16);
        gp.obj[15].screenX = 92 * 3;
        gp.obj[15].screenY = 90 * 3;

        gp.obj[16] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island7.png", 16  ,16);
        gp.obj[16].screenX = 108 * 3;
        gp.obj[16].screenY = 90 * 3;

        gp.obj[17] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island8.png", 16  ,16);
        gp.obj[17].screenX = 108 * 3;
        gp.obj[17].screenY = 75 * 3;

        gp.obj[18] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island9.png", 16  ,16);
        gp.obj[18].screenX = 123 * 3;
        gp.obj[18].screenY = 75 * 3;

        gp.obj[19] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island10.png", 16  ,16);
        gp.obj[19].screenX = 123 * 3;
        gp.obj[19].screenY = 60 * 3;

        gp.obj[20] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island11.png", 16  ,16);
        gp.obj[20].screenX = 138 * 3;
        gp.obj[20].screenY = 60 * 3;

        gp.obj[21] = new OBJ_Kitchen("microwave", "/rooms/kitchen/kitchen_OBJ/microwave.png", 16  ,16);
        gp.obj[21].screenX = 35 * 3;
        gp.obj[21].screenY = 28 * 2;

        gp.obj[22] = new OBJ_Avocados();
        gp.obj[22].screenX = 85 * 3;
        gp.obj[22].screenY = 34 * 2;

        gp.obj[23] = new OBJ_Oranges();
        gp.obj[23].screenX = 95 * 3;
        gp.obj[23].screenY = 86 * 3;

        gp.obj[24] = new OBJ_Radio();
        gp.obj[24].screenX = 123 * 3;
        gp.obj[24].screenY = 58 * 3;


        gp.obj[25] = new OBJ_Kitchen("table", "/rooms/kitchen/kitchen_OBJ/table.png", 25  ,25);
        gp.obj[25].screenX = 40 * 3;
        gp.obj[25].screenY = 146 * 3;


        gp.obj[26] = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-left.png", 14  ,22);
        gp.obj[26].screenX = 24 * 3;
        gp.obj[26].screenY = 143 * 3;


        gp.obj[27] = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-right.png", 14  ,22);
        gp.obj[27].screenX = 66 * 3;
        gp.obj[27].screenY = 145 * 3;

        gp.obj[28] = new OBJ_Kitchen("flowers", "/rooms/kitchen/kitchen_OBJ/flowers.png", 16  ,16);
        gp.obj[28].screenX = 45 * 3;
        gp.obj[28].screenY = 145 * 3;

        gp.obj[29] = new OBJ_Kitchen("knife", "/rooms/kitchen/kitchen_OBJ/knife.png", 18  ,21);
        gp.obj[29].screenX = 47 * 3;
        gp.obj[29].screenY = 61 * 3;
        gp.obj[29].solidArea.y = gp.obj[29].solidArea.y * 3;
        gp.obj[29].solidArea.x = gp.obj[29].solidArea.x * 3;
        gp.obj[29].gettable = true;
    }
}
