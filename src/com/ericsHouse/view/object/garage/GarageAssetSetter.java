package com.ericsHouse.view.object.garage;

import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import java.util.Arrays;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class GarageAssetSetter extends AssetSetter {


    public GarageAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {
        //Y moves object up and down
        //X moves object left and right
        Arrays.fill(gp.obj, null);
        gp.obj = new SuperObject[10];

        OBJ_Dresser dresser1 = new OBJ_Dresser();
        dresser1.screenX = 48;
        dresser1.screenY = 16;
        roomMap.get("garage").mapObjects.put("dresser1", dresser1);
//        gp.obj[0] = new OBJ_Dresser();
//        gp.obj[0].screenY = 16;
//        gp.obj[0].screenX = 48;

        OBJ_Dresser dresser2 = new OBJ_Dresser();
        dresser2.screenX = 139;
        dresser2.screenY = 16;
        roomMap.get("garage").mapObjects.put("dresser2", dresser2);
//        gp.obj[1] = new OBJ_Dresser();
//        gp.obj[1].screenY = 16;
//        gp.obj[1].screenX = 139;

        OBJ_Glasses glasses = new OBJ_Glasses();
        glasses.screenX = 145;
        glasses.screenY = 50;
        roomMap.get("garage").mapObjects.put("glasses", glasses);
//        gp.obj[9] = new OBJ_Glasses();
//        gp.obj[9].screenY = 50;
//        gp.obj[9].screenX = 145;

        OBJ_Dresser dresser3 = new OBJ_Dresser();
        dresser3.screenX = 230;
        dresser3.screenY = 16;
        roomMap.get("garage").mapObjects.put("dresser3", dresser3);
//        gp.obj[2] = new OBJ_Dresser();
//        gp.obj[2].screenY = 16;
//        gp.obj[2].screenX = 230;

        OBJ_Frog frog = new OBJ_Frog();
        frog.screenX = 145;
        frog.screenY = -15;
        roomMap.get("garage").mapObjects.put("frog", frog);
//        gp.obj[3] = new OBJ_Frog();
//        gp.obj[3].screenY = -15;
//        gp.obj[3].screenX = 145;

        OBJ_Curtains curtains = new OBJ_Curtains();
        curtains.screenX = 400;
        curtains.screenY = 4;
        roomMap.get("garage").mapObjects.put("curtains", curtains);
//        gp.obj[4] = new OBJ_Curtains();
//        gp.obj[4].screenY = 4;
//        gp.obj[4].screenX = 400;

        OBJ_Note note = new OBJ_Note();
        note.screenX = 90;
        note.screenY = 400;
        roomMap.get("garage").mapObjects.put("note", note);
//        gp.obj[5] = new OBJ_Note();
//        gp.obj[5].screenY = 400;
//        gp.obj[5].screenX = 90;

        OBJ_Poster poster = new OBJ_Poster();
        poster.screenX = 570;
        poster.screenY = 20;
        roomMap.get("garage").mapObjects.put("poster", poster);
//        gp.obj[6] = new OBJ_Poster();
//        gp.obj[6].screenY = 20;
//        gp.obj[6].screenX = 570;

        OBJ_Car car = new OBJ_Car();
        car.screenX = 300;
        car.screenY = 100;
        roomMap.get("garage").mapObjects.put("car", car);
//        gp.obj[7] = new OBJ_Car();
//        gp.obj[7].screenY = 100;
//        gp.obj[7].screenX = 300;

        OBJ_Door door = new OBJ_Door();
        door.screenX = 0;
        door.screenY = 144;
        roomMap.get("garage").mapObjects.put("door", door);
//        gp.obj[8] = new OBJ_Door();
//        gp.obj[8].screenY = 144;
//        gp.obj[8].screenX = 0;
    }
}
