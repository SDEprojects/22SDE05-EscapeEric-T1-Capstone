package com.ericsHouse.view.object.kitchen;

import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.panels.GamePanel;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class KitchenAssetSetter extends AssetSetter {
    public KitchenAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {
        //TODO put all the object instantiation information in a txt or json file and parse it and
        // Resetting the obj array for the kitchen objects to be drawn in the room

        //Setting all objects in the kitchen
        OBJ_Fridge fridge = new OBJ_Fridge();
        fridge.screenX = 11 * 3;
        fridge.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("fridge", fridge);

        OBJ_Cabinet cabinet = new OBJ_Cabinet();
        cabinet.screenX = 31 * 3;
        cabinet.screenY = 0;
        roomMap.get("kitchen").mapObjects.put("cabinet", cabinet);

        OBJ_Hutch hutch = new OBJ_Hutch();
        hutch.screenX = 61 * 3;
        hutch.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("hutch", hutch);

        OBJ_Sink sink = new OBJ_Sink();
        sink.screenX = 82 * 3;
        sink.screenY = 0;
        roomMap.get("kitchen").mapObjects.put("sink", sink);

        OBJ_Oven oven = new OBJ_Oven();
        oven.screenX = 142 * 3;
        oven.screenY = 15;
        roomMap.get("kitchen").mapObjects.put("oven", oven);

        OBJ_Kitchen hutch1 = new OBJ_Kitchen("hutch", "/rooms/kitchen/kitchen_OBJ/hutch.png", 22, 34);
        hutch1.screenX = 175 * 3;
        hutch1.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("hutch1", hutch1);

        OBJ_Kitchen door = new OBJ_Kitchen("door", "/rooms/kitchen/kitchen_OBJ/door.png", 26, 30);
        door.screenX = 205 * 3;
        door.screenY = 10;
        roomMap.get("kitchen").mapObjects.put("door", door);

        OBJ_Kitchen housePlant = new OBJ_Kitchen("house-plant", "/rooms/kitchen/kitchen_OBJ/house-plant.png", 18, 28);
        housePlant.screenX = 229 * 3;
        housePlant.screenY = 36;
        roomMap.get("kitchen").mapObjects.put("housePlant", housePlant);

        OBJ_Kitchen catPic = new OBJ_Kitchen("cat-pic", "/rooms/kitchen/kitchen_OBJ/cat-pic.png", 16, 16);
        catPic.screenX = 65 * 3;
        catPic.screenY = -10;
        roomMap.get("kitchen").mapObjects.put("catPic", catPic);

        OBJ_Kitchen island1 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island1.png", 16, 16);
        island1.screenX = 47 * 3;
        island1.screenY = 62 * 3;
        roomMap.get("kitchen").mapObjects.put("island1", island1);

        OBJ_Kitchen island2 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island2.png", 16, 16);
        island2.screenX = 62 * 3;
        island2.screenY = 62 * 3;
        roomMap.get("kitchen").mapObjects.put("island2", island2);

        OBJ_Kitchen island3 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island3.png", 16, 16);
        island3.screenX = 62 * 3;
        island3.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island3", island3);

        OBJ_Kitchen island4 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island4.png", 16, 16);
        island4.screenX = 78 * 3;
        island4.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island4", island4);

        OBJ_Kitchen island5 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island5.png", 16, 16);
        island5.screenX = 78 * 3;
        island5.screenY = 90 * 3;
        roomMap.get("kitchen").mapObjects.put("island5", island5);

        OBJ_Kitchen island6 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island6.png", 16, 16);
        island6.screenX = 92 * 3;
        island6.screenY = 90 * 3;
        roomMap.get("kitchen").mapObjects.put("island6", island6);

        OBJ_Kitchen island7 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island7.png", 16, 16);
        island7.screenX = 108 * 3;
        island7.screenY = 90 * 3;
        roomMap.get("kitchen").mapObjects.put("island7", island7);

        OBJ_Kitchen island8 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island8.png", 16, 16);
        island8.screenX = 108 * 3;
        island8.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island8", island8);

        OBJ_Kitchen island9 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island9.png", 16, 16);
        island9.screenX = 123 * 3;
        island9.screenY = 75 * 3;
        roomMap.get("kitchen").mapObjects.put("island9", island9);

        OBJ_Kitchen island10 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island10.png", 16, 16);
        island10.screenX = 123 * 3;
        island10.screenY = 60 * 3;
        roomMap.get("kitchen").mapObjects.put("island10", island10);

        OBJ_Kitchen island11 = new OBJ_Kitchen("island", "/rooms/kitchen/kitchen_OBJ/island11.png", 16, 16);
        island11.screenX = 138 * 3;
        island11.screenY = 60 * 3;
        roomMap.get("kitchen").mapObjects.put("island11", island11);

        OBJ_Kitchen microwave = new OBJ_Kitchen("microwave", "/rooms/kitchen/kitchen_OBJ/microwave.png", 16, 16);
        microwave.screenX = 35 * 3;
        microwave.screenY = 28 * 2;
        roomMap.get("kitchen").mapObjects.put("microwave", microwave);

        OBJ_Pears pears = new OBJ_Pears();
        pears.screenX = 85 * 3;
        pears.screenY = 34 * 2;
        roomMap.get("kitchen").mapObjects.put("pears", pears);

        OBJ_Kitchen table = new OBJ_Kitchen("table", "/rooms/kitchen/kitchen_OBJ/table.png", 25, 25);
        table.screenX = 40 * 3;
        table.screenY = 146 * 3;
        roomMap.get("kitchen").mapObjects.put("table", table);

        OBJ_Kitchen chair1 = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-left.png", 14, 22);
        chair1.screenX = 24 * 3;
        chair1.screenY = 143 * 3;
        roomMap.get("kitchen").mapObjects.put("chair1", chair1);

        OBJ_Kitchen chair2 = new OBJ_Kitchen("chair", "/rooms/kitchen/kitchen_OBJ/chair-right.png", 14, 22);
        chair2.screenX = 66 * 3;
        chair2.screenY = 145 * 3;
        roomMap.get("kitchen").mapObjects.put("chair2", chair2);

        OBJ_Kitchen flowers = new OBJ_Kitchen("flowers", "/rooms/kitchen/kitchen_OBJ/flowers.png", 16, 16);
        flowers.screenX = 45 * 3;
        flowers.screenY = 145 * 3;
        roomMap.get("kitchen").mapObjects.put("flowers", flowers);

        OBJ_Knife knife = new OBJ_Knife();
        knife.screenX = 47 * 3;
        knife.screenY = 61 * 3;
        roomMap.get("kitchen").mapObjects.put("knife", knife);

        OBJ_Oranges oranges = new OBJ_Oranges();
        oranges.screenX = 95 * 3;
        oranges.screenY = 86 * 3;
        roomMap.get("kitchen").mapObjects.put("oranges", oranges);

        OBJ_Radio radio = new OBJ_Radio();
        radio.screenX = 123 * 3;
        radio.screenY = 58 * 3;
        roomMap.get("kitchen").mapObjects.put("radio", radio);
    }
}
