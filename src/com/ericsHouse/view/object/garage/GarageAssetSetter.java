package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.panels.GamePanel;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class GarageAssetSetter extends AssetSetter {


    public GarageAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {
        //Y moves object up and down
        //X moves object left and right

        OBJ_Dresser dresser1 = new OBJ_Dresser();
        dresser1.screenX = 48;
        dresser1.screenY = 16;
        roomMap.get("garage").mapObjects.put("dresser1", dresser1);

        OBJ_Dresser dresser2 = new OBJ_Dresser();
        dresser2.screenX = 139;
        dresser2.screenY = 16;
        roomMap.get("garage").mapObjects.put("dresser2", dresser2);

        OBJ_Glasses glasses = new OBJ_Glasses();
        glasses.screenX = 145;
        glasses.screenY = 50;
        roomMap.get("garage").mapObjects.put("glasses", glasses);

        OBJ_Dresser dresser3 = new OBJ_Dresser();
        dresser3.screenX = 230;
        dresser3.screenY = 16;
        roomMap.get("garage").mapObjects.put("dresser3", dresser3);

        OBJ_Frog frog = new OBJ_Frog();
        frog.screenX = 145;
        frog.screenY = -15;
        roomMap.get("garage").mapObjects.put("frog", frog);

        OBJ_Curtains curtains = new OBJ_Curtains();
        curtains.screenX = 400;
        curtains.screenY = 4;
        roomMap.get("garage").mapObjects.put("curtains", curtains);

        OBJ_Note note = new OBJ_Note();
        note.screenX = 90;
        note.screenY = 400;
        roomMap.get("garage").mapObjects.put("note", note);

        OBJ_Poster poster = new OBJ_Poster();
        poster.screenX = 570;
        poster.screenY = 20;
        roomMap.get("garage").mapObjects.put("poster", poster);

        OBJ_Car car = new OBJ_Car();
        car.screenX = 300;
        car.screenY = 100;
        roomMap.get("garage").mapObjects.put("car", car);

        OBJ_Door door = new OBJ_Door();
        door.screenX = 0;
        door.screenY = 144;
        roomMap.get("garage").mapObjects.put("door", door);

        OBJ_WorkBench workbench = new OBJ_WorkBench();
        workbench.screenX = 223 * 3;
        workbench.screenY = 117 * 3;
        roomMap.get("garage").mapObjects.put("workbench", workbench);
    }
}
