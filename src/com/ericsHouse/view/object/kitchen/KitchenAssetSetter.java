package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;

import java.util.Arrays;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class KitchenAssetSetter extends AssetSetter {
    public KitchenAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject(){
        //TODO put all the object instantiation information in a txt or json file and parse it and
        // Resetting the obj array for the kitchen objects to be drawn in the room
        Arrays.fill(gp.obj, null);
        gp.obj = new SuperObject[30];

        //Setting all objects in the kitchen
        OBJ_Fridge fridge = new OBJ_Fridge();
        fridge.screenX = 11 * 3;
        fridge.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("fridge", fridge);
//        gp.obj[0] = new OBJ_Fridge();
//        gp.obj[0].screenX = 11 * 3;
//        gp.obj[0].screenY = 36 ;

        OBJ_Cabinet cabinet = new OBJ_Cabinet();
        cabinet.screenX = 31 * 3;
        cabinet.screenY = 0;
        roomMap.get("kitchen").mapObjects.put("cabinet", cabinet);
//        gp.obj[1] = new OBJ_Cabinet();
//        gp.obj[1].screenX = 31 * 3;
//        gp.obj[1].screenY = 0 ;

        OBJ_Hutch hutch = new OBJ_Hutch();
        hutch.screenX = 61 * 3;
        hutch.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("hutch", hutch);
//        gp.obj[2] = new OBJ_Hutch();
//        gp.obj[2].screenX = 61 * 3;
//        gp.obj[2].screenY = 36;

        OBJ_Sink sink = new OBJ_Sink();
        sink.screenX = 82 * 3;
        sink.screenY = 0;
        roomMap.get("kitchen").mapObjects.put("sink", sink);
//        gp.obj[3] = new OBJ_Sink();
//        gp.obj[3].screenX = 82 * 3;
//        gp.obj[3].screenY = 0 ;

        OBJ_Oven oven = new OBJ_Oven();
        oven.screenX = 142 * 3;
        oven.screenY = 15;
        roomMap.get("kitchen").mapObjects.put("oven", oven);
//        gp.obj[4] = new OBJ_Oven();
//        gp.obj[4].screenX = 142 * 3;
//        gp.obj[4].screenY = 15;

        OBJ_Kitchen hutch1 = new OBJ_Kitchen("hutch", "/rooms/kitchen/kitchen_OBJ/hutch.png",22,34);
        hutch1.screenX = 175 * 3;
        hutch1.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("hutch1", hutch1);
//        gp.obj[5] = new OBJ_Kitchen("hutch", "/rooms/kitchen/kitchen_OBJ/hutch.png",22,34);
//        gp.obj[5].screenX = 175 * 3;
//        gp.obj[5].screenY = 36;

        OBJ_Kitchen door = new OBJ_Kitchen("door", "/rooms/kitchen/kitchen_OBJ/door.png", 26,30);
        door.screenX = 205 * 3;
        door.screenY = 10;
        roomMap.get("kitchen").mapObjects.put("door", door);
//        gp.obj[7] = new OBJ_Kitchen("door", "/rooms/kitchen/kitchen_OBJ/door.png", 26,30);
//        gp.obj[7].screenX = 205 * 3;
//        gp.obj[7].screenY = 10;

        OBJ_Kitchen housePlant = new OBJ_Kitchen("house-plant", "/rooms/kitchen/kitchen_OBJ/house-plant.png", 18,28);
        housePlant.screenX = 229 * 3;
        housePlant.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("housePlant", housePlant);
//        gp.obj[8] = new OBJ_Kitchen("house-plant", "/rooms/kitchen/kitchen_OBJ/house-plant.png", 18,28);
//        gp.obj[8].screenX = 229 * 3;
//        gp.obj[8].screenY = 36;

        OBJ_Kitchen catPic = new OBJ_Kitchen("cat-pic", "/rooms/kitchen/kitchen_OBJ/cat-pic.png", 16  ,16);
        catPic.screenX = 65 * 3;
        catPic.screenY = -10;
        roomMap.get("kitchen").mapObjects.put("catPic", catPic);
//        gp.obj[9] = new OBJ_Kitchen("cat-pic", "/rooms/kitchen/kitchen_OBJ/cat-pic.png", 16  ,16);
//        gp.obj[9].screenX = 65 * 3;
//        gp.obj[9].screenY = -10;

        OBJ_Kitchen island1 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island1.screenX = 47 * 3;
        island1.screenY = 62 * 3;
        roomMap.get("kitchen").mapObjects.put("island1", island1);
//        gp.obj[10] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
//        gp.obj[10].screenX = 47 * 3;
//        gp.obj[10].screenY = 62 * 3;

        OBJ_Kitchen island2 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island2.screenX = 62 * 3;
        island2.screenY = 62 * 3;
        roomMap.get("kitchen").mapObjects.put("island2", island2);
//        gp.obj[11] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island2.png", 16  ,16);
//        gp.obj[11].screenX = 62 * 3;
//        gp.obj[11].screenY = 62 * 3;

        OBJ_Kitchen island3 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island3.screenX = 62 * 3;
        island3.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island3", island3);
//        gp.obj[12] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island3.png", 16  ,16);
//        gp.obj[12].screenX = 62 * 3;
//        gp.obj[12].screenY = 75 * 3;

        OBJ_Kitchen island4 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island4.screenX = 78 * 3;
        island4.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island4", island4);
//        gp.obj[13] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island4.png", 16  ,16);
//        gp.obj[13].screenX = 78 * 3;
//        gp.obj[13].screenY = 75 * 3;

        OBJ_Kitchen island5 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island5.screenX = 78 * 3;
        island5.screenY = 90 * 3;
        roomMap.get("kitchen").mapObjects.put("island5", island5);
//        gp.obj[14] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island5.png", 16  ,16);
//        gp.obj[14].screenX = 78 * 3;
//        gp.obj[14].screenY = 90 * 3;

        OBJ_Kitchen island6 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island6.screenX = 92 * 3;
        island6.screenY = 90 * 3;
        roomMap.get("kitchen").mapObjects.put("island6", island6);
//        gp.obj[15] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island6.png", 16  ,16);
//        gp.obj[15].screenX = 92 * 3;
//        gp.obj[15].screenY = 90 * 3;

        OBJ_Kitchen island7 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island7.screenX = 108 * 3;
        island7.screenY = 90 * 3;
        roomMap.get("kitchen").mapObjects.put("island7", island7);
//        gp.obj[16] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island7.png", 16  ,16);
//        gp.obj[16].screenX = 108 * 3;
//        gp.obj[16].screenY = 90 * 3;

        OBJ_Kitchen island8 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island8.screenX = 108 * 3;
        island8.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island8", island8);
//        gp.obj[17] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island8.png", 16  ,16);
//        gp.obj[17].screenX = 108 * 3;
//        gp.obj[17].screenY = 75 * 3;

        OBJ_Kitchen island9 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island9.screenX = 123 * 3;
        island9.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island9", island9);
//        gp.obj[18] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island9.png", 16  ,16);
//        gp.obj[18].screenX = 123 * 3;
//        gp.obj[18].screenY = 75 * 3;

        OBJ_Kitchen island10 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island10.screenX = 123 * 3;
        island10.screenY = 60 * 3;
        roomMap.get("kitchen").mapObjects.put("island10", island10);
//        gp.obj[19] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island10.png", 16  ,16);
//        gp.obj[19].screenX = 123 * 3;
//        gp.obj[19].screenY = 60 * 3;

        OBJ_Kitchen island11 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16  ,16);
        island11.screenX = 138 * 3;
        island11.screenY = 60 * 3;
        roomMap.get("kitchen").mapObjects.put("island11", island11);
//        gp.obj[20] = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island11.png", 16  ,16);
//        gp.obj[20].screenX = 138 * 3;
//        gp.obj[20].screenY = 60 * 3;

        OBJ_Kitchen microwave = new OBJ_Kitchen("microwave", "/rooms/kitchen/kitchen_OBJ/microwave.png", 16  ,16);
        microwave.screenX = 35 * 3;
        microwave.screenY = 28 * 2;
        roomMap.get("kitchen").mapObjects.put("microwave", microwave);
//        gp.obj[21] = new OBJ_Kitchen("microwave", "/rooms/kitchen/kitchen_OBJ/microwave.png", 16  ,16);
//        gp.obj[21].screenX = 35 * 3;
//        gp.obj[21].screenY = 28 * 2;
        gp.obj[22] = new OBJ_Pears();
        gp.obj[22].screenX = 85 * 3;
        gp.obj[22].screenY = 34 * 2;

        OBJ_Avocados avocados = new OBJ_Avocados();
        avocados.screenX = 85 * 3;
        avocados.screenY = 34 * 2;
        roomMap.get("kitchen").mapObjects.put("avocados", avocados);
//        gp.obj[22] = new OBJ_Avocados();
//        gp.obj[22].screenX = 85 * 3;
//        gp.obj[22].screenY = 34 * 2;

        OBJ_Oranges oranges = new OBJ_Oranges();
        oranges.screenX = 95 * 3;
        oranges.screenY = 86 * 3;
        roomMap.get("kitchen").mapObjects.put("oranges", oranges);
//        gp.obj[23] = new OBJ_Oranges();
//        gp.obj[23].screenX = 95 * 3;
//        gp.obj[23].screenY = 86 * 3;

        OBJ_Radio radio = new OBJ_Radio();
        radio.screenX = 123 * 3;
        radio.screenY = 58 * 3;
        roomMap.get("kitchen").mapObjects.put("radio", radio);
//        gp.obj[24] = new OBJ_Radio();
//        gp.obj[24].screenX = 123 * 3;
//        gp.obj[24].screenY = 58 * 3;

        OBJ_Kitchen table = new OBJ_Kitchen("table", "/rooms/kitchen/kitchen_OBJ/table.png", 25  ,25);
        table.screenX = 40 * 3;
        table.screenY = 146 * 3;
        roomMap.get("kitchen").mapObjects.put("table", table);
//        gp.obj[25] = new OBJ_Kitchen("table", "/rooms/kitchen/kitchen_OBJ/table.png", 25  ,25);
//        gp.obj[25].screenX = 40 * 3;
//        gp.obj[25].screenY = 146 * 3;

        OBJ_Kitchen chair1 = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-left.png", 14  ,22);
        chair1.screenX = 24 * 3;
        chair1.screenY = 143 * 3;
        roomMap.get("kitchen").mapObjects.put("chair1", chair1);
//        gp.obj[26] = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-left.png", 14  ,22);
//        gp.obj[26].screenX = 24 * 3;
//        gp.obj[26].screenY = 143 * 3;

        OBJ_Kitchen chair2 = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-left.png", 14  ,22);
        chair2.screenX = 24 * 3;
        chair2.screenY = 143 * 3;
        roomMap.get("kitchen").mapObjects.put("chair2", chair2);
//        gp.obj[27] = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-right.png", 14  ,22);
//        gp.obj[27].screenX = 66 * 3;
//        gp.obj[27].screenY = 145 * 3;

        OBJ_Kitchen flowers = new OBJ_Kitchen("flowers", "/rooms/kitchen/kitchen_OBJ/flowers.png", 16  ,16);
        flowers.screenX = 45 * 3;
        flowers.screenY = 145 * 3;
        roomMap.get("kitchen").mapObjects.put("flowers", flowers);
//        gp.obj[28] = new OBJ_Kitchen("flowers", "/rooms/kitchen/kitchen_OBJ/flowers.png", 16  ,16);
//        gp.obj[28].screenX = 45 * 3;
//        gp.obj[28].screenY = 145 * 3;

        OBJ_Kitchen knife = new OBJ_Kitchen("knife", "/rooms/kitchen/kitchen_OBJ/knife.png", 18  ,21);
        knife.screenX = 47 * 3;
        knife.screenY = 61 * 3;
        knife.solidArea.x *= 3;
        knife.solidArea.y *= 3;
        knife.gettable = true;
        roomMap.get("kitchen").mapObjects.put("knife", knife);
//        gp.obj[29] = new OBJ_Kitchen("knife", "/rooms/kitchen/kitchen_OBJ/knife.png", 18  ,21);
//        gp.obj[29].screenX = 47 * 3;
//        gp.obj[29].screenY = 61 * 3;
//        gp.obj[29].solidArea.y = gp.obj[29].solidArea.y * 3;
//        gp.obj[29].solidArea.x = gp.obj[29].solidArea.x * 3;
//        gp.obj[29].gettable = true;
    }
}
