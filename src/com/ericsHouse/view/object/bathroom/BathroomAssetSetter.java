package com.ericsHouse.view.object.bathroom;

import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;
import com.ericsHouse.view.panels.GamePanel;

import java.util.Arrays;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class BathroomAssetSetter extends AssetSetter {

    public BathroomAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {
        Arrays.fill(gp.obj, null);
        gp.obj = new SuperObject[24];

        OBJ_Bathroom bathtub = new OBJ_Bathroom("bathtub", "/rooms/bathroom/bathroom_OBJ/bathtub.png", 31, 32);
        bathtub.screenX = 4 * 3;
        bathtub.screenY = 104 * 3;
        roomMap.get("bathroom").mapObjects.put("bathtub", bathtub);
//        gp.obj[0] = new OBJ_Bathroom("bathtub", "/rooms/bathroom/bathroom_OBJ/bathtub.png",31,32);
//        gp.obj[0].screenX = 4 * 3;
//        gp.obj[0].screenY = 104 * 3;

        OBJ_Bathroom toilet = new OBJ_Bathroom("toilet", "/rooms/bathroom/bathroom_OBJ/toilet.png", 13, 22);
        toilet.screenX = 23 * 3;
        toilet.screenY = 47 * 3;
        roomMap.get("bathroom").mapObjects.put("toilet", toilet);
//        gp.obj[1] = new OBJ_Bathroom("toilet", "/rooms/bathroom/bathroom_OBJ/toilet.png",13,22);
//        gp.obj[1].screenX = 23 * 3;
//        gp.obj[1].screenY = 47 * 3;

        OBJ_Bathroom seat = new OBJ_Bathroom("seat", "/rooms/bathroom/bathroom_OBJ/seat.png", 17, 16);
        seat.screenX = 101 * 3;
        seat.screenY = 56 * 3;
        roomMap.get("bathroom").mapObjects.put("seat", seat);
//        gp.obj[2] = new OBJ_Bathroom("seat", "/rooms/bathroom/bathroom_OBJ/seat.png",17,16);
//        gp.obj[2].screenX = 101 * 3;
//        gp.obj[2].screenY = 56 * 3;

        OBJ_Bathroom towelHolder1 = new OBJ_Bathroom("towel-holder", "/rooms/bathroom/bathroom_OBJ/towel-holder.png", 18, 12);
        towelHolder1.screenX = 101 * 3;
        towelHolder1.screenY = 34 * 3;
        roomMap.get("bathroom").mapObjects.put("towelHolder1", towelHolder1);
//        gp.obj[3] = new OBJ_Bathroom("towel-holder", "/rooms/bathroom/bathroom_OBJ/towel-holder.png",18,12);
//        gp.obj[3].screenX = 101 * 3;
//        gp.obj[3].screenY = 34 * 3;

        OBJ_Bathroom towelHolder2 = new OBJ_Bathroom("towel-holder", "/rooms/bathroom/bathroom_OBJ/towel-holder.png", 18, 12);
        towelHolder2.screenX = 176 * 3;
        towelHolder2.screenY = 35 * 3;
        roomMap.get("bathroom").mapObjects.put("towelHolder2", towelHolder2);
//        gp.obj[4] = new OBJ_Bathroom("towel-holder", "/rooms/bathroom/bathroom_OBJ/towel-holder.png",18,12);
//        gp.obj[4].screenX = 176 * 3;
//        gp.obj[4].screenY = 35 * 3;

        OBJ_Bathroom wallMirror1 = new OBJ_Bathroom("wall-mirror", "/rooms/bathroom/bathroom_OBJ/wall-mirror.png", 11, 13);
        wallMirror1.screenX = 128 * 3;
        wallMirror1.screenY = 28 * 3;
        roomMap.get("bathroom").mapObjects.put("wallMirror1", wallMirror1);
//        gp.obj[5] = new OBJ_Bathroom("wall-mirror", "/rooms/bathroom/bathroom_OBJ/wall-mirror.png",11,13);
//        gp.obj[5].screenX = 128 * 3;
//        gp.obj[5].screenY = 28 * 3;

        OBJ_Bathroom wallMirror2 = new OBJ_Bathroom("wall-mirror", "/rooms/bathroom/bathroom_OBJ/wall-mirror.png", 11, 13);
        wallMirror2.screenX = 156 * 3;
        wallMirror2.screenY = 28 * 3;
        roomMap.get("bathroom").mapObjects.put("wallMirror2", wallMirror2);
//        gp.obj[6] = new OBJ_Bathroom("wall-mirror", "/rooms/bathroom/bathroom_OBJ/wall-mirror.png",11,13);
//        gp.obj[6].screenX = 156 * 3;
//        gp.obj[6].screenY = 28 * 3;

        OBJ_Bathroom davidMirror = new OBJ_Bathroom("david-mirror", "/rooms/bathroom/bathroom_OBJ/david-mirror.png", 22, 39);
        davidMirror.screenX = 203 * 3;
        davidMirror.screenY = 25 * 3;
        roomMap.get("bathroom").mapObjects.put("davidMirror", davidMirror);
//        gp.obj[7] = new OBJ_Bathroom("david-mirror", "/rooms/bathroom/bathroom_OBJ/david-mirror.png",22,39);
//        gp.obj[7].screenX = 203 * 3;
//        gp.obj[7].screenY = 25 * 3;

        OBJ_Bathroom bathroomSink = new OBJ_Bathroom("bathroom-sink", "/rooms/bathroom/bathroom_OBJ/bathroom-sink.png", 54, 30);
        bathroomSink.screenX = 120 * 3;
        bathroomSink.screenY = 37 * 3;
        roomMap.get("bathroom").mapObjects.put("bathroomSink", bathroomSink);
//        gp.obj[8] = new OBJ_Bathroom("bathroom-sink", "/rooms/bathroom/bathroom_OBJ/bathroom-sink.png",54,30);
//        gp.obj[8].screenX = 120 * 3;
//        gp.obj[8].screenY = 37 * 3;

        OBJ_Bathroom shelves = new OBJ_Bathroom("shelves", "/rooms/bathroom/bathroom_OBJ/shelves.png", 32, 34);
        shelves.screenX = 67 * 3;
        shelves.screenY = 31 * 3;
        roomMap.get("bathroom").mapObjects.put("shelves", shelves);
//        gp.obj[9] = new OBJ_Bathroom("shelves", "/rooms/bathroom/bathroom_OBJ/shelves.png",32,34);
//        gp.obj[9].screenX = 67 * 3;
//        gp.obj[9].screenY = 31 * 3;

        OBJ_Bathroom greenBottle = new OBJ_Bathroom("green-bottle", "/rooms/bathroom/bathroom_OBJ/green-bottle.png", 7, 9);
        greenBottle.screenX = 23 * 3;
        greenBottle.screenY = 43 * 3;
        roomMap.get("bathroom").mapObjects.put("greenBottle", greenBottle);
//        gp.obj[10] = new OBJ_Bathroom("green-bottle", "/rooms/bathroom/bathroom_OBJ/green-bottle.png",7,9);
//        gp.obj[10].screenX = 23 * 3;
//        gp.obj[10].screenY = 43 * 3;

        OBJ_Bathroom towelPile1 = new OBJ_Bathroom("towel-pile-1", "/rooms/bathroom/bathroom_OBJ/towel-pile-1.png", 16, 14);
        towelPile1.screenX = 5 * 3;
        towelPile1.screenY = 90 * 3;
        roomMap.get("bathroom").mapObjects.put("towelPile1", towelPile1);
//        gp.obj[11] = new OBJ_Bathroom("towel-pile-1", "/rooms/bathroom/bathroom_OBJ/towel-pile-1.png",16,14);
//        gp.obj[11].screenX = 5 * 3;
//        gp.obj[11].screenY = 90 * 3;

        OBJ_Bathroom towelPile2 = new OBJ_Bathroom("towel-pile-1", "/rooms/bathroom/bathroom_OBJ/towel-pile-1.png", 16, 14);
        towelPile2.screenX = 203 * 3;
        towelPile2.screenY = 162 * 3;
        roomMap.get("bathroom").mapObjects.put("towelPile2", towelPile2);
//        gp.obj[12] = new OBJ_Bathroom("towel-pile-1", "/rooms/bathroom/bathroom_OBJ/towel-pile-1.png",16,14);
//        gp.obj[12].screenX = 203 * 3;
//        gp.obj[12].screenY = 162 * 3;

        OBJ_Bathroom towelPile3 = new OBJ_Bathroom("towel-pile-2", "/rooms/bathroom/bathroom_OBJ/towel-pile-2.png", 16, 11);
        towelPile3.screenX = 186 * 3;
        towelPile3.screenY = 161 * 3;
        roomMap.get("bathroom").mapObjects.put("towelPile3", towelPile3);
//        gp.obj[13] = new OBJ_Bathroom("towel-pile-2", "/rooms/bathroom/bathroom_OBJ/towel-pile-2.png",16,11);
//        gp.obj[13].screenX = 186 * 3;
//        gp.obj[13].screenY = 161 * 3;

        OBJ_Bathroom towelPile4 = new OBJ_Bathroom("towel-pile-3", "/rooms/bathroom/bathroom_OBJ/towel-pile-3.png", 16, 16);
        towelPile4.screenX = 198 * 3;
        towelPile4.screenY = 145 * 3;
        roomMap.get("bathroom").mapObjects.put("towelPile4", towelPile4);
//        gp.obj[14] = new OBJ_Bathroom("towel-pile-3", "/rooms/bathroom/bathroom_OBJ/towel-pile-3.png",16,16);
//        gp.obj[14].screenX = 198 * 3;
//        gp.obj[14].screenY = 145 * 3;

        OBJ_Bathroom washerDryer = new OBJ_Bathroom("washer-dryer", "/rooms/bathroom/bathroom_OBJ/washer-dryer.png", 32, 23);
        washerDryer.screenX = 219 * 3;
        washerDryer.screenY = 139 * 3;
        roomMap.get("bathroom").mapObjects.put("washerDryer", washerDryer);
//        gp.obj[15] = new OBJ_Bathroom("washer-dryer", "/rooms/bathroom/bathroom_OBJ/washer-dryer.png",32,23);
//        gp.obj[15].screenX = 219 * 3;
//        gp.obj[15].screenY = 139 * 3;

        OBJ_Bathroom rug = new OBJ_Bathroom("rug", "/rooms/bathroom/bathroom_OBJ/rug.png", 47, 32);
        rug.screenX = 103 * 3;
        rug.screenY = 108 * 3;
        rug.collision = false;
        roomMap.get("bathroom").mapObjects.put("rug", rug);
//        gp.obj[16] = new OBJ_Bathroom("rug", "/rooms/bathroom/bathroom_OBJ/rug.png",47,32);
//        gp.obj[16].screenX = 103 * 3;
//        gp.obj[16].screenY = 108 * 3;
//        gp.obj[16].collision = false;

        OBJ_Bathroom toothbrush = new OBJ_Bathroom("toothbrush", "/rooms/bathroom/bathroom_OBJ/toothbrush.png", 8, 8);
        toothbrush.screenX = 143 * 3;
        toothbrush.screenY = 31 * 3;
        roomMap.get("bathroom").mapObjects.put("toothbrush", toothbrush);
//        gp.obj[17] = new OBJ_Bathroom("toothbrush", "/rooms/bathroom/bathroom_OBJ/toothbrush.png",8,8);
//        gp.obj[17].screenX = 143 * 3;
//        gp.obj[17].screenY = 31 * 3;

        OBJ_Bathroom flower1 = new OBJ_Bathroom("flower", "/rooms/bathroom/bathroom_OBJ/flower.png", 18, 28);
        flower1.screenX = 5 * 3;
        flower1.screenY = 42 * 3;
        roomMap.get("bathroom").mapObjects.put("flower1", flower1);
//        gp.obj[18] = new OBJ_Bathroom("flower", "/rooms/bathroom/bathroom_OBJ/flower.png",18,28);
//        gp.obj[18].screenX = 5 * 3;
//        gp.obj[18].screenY = 42 * 3;

        OBJ_Bathroom flower2 = new OBJ_Bathroom("flower", "/rooms/bathroom/bathroom_OBJ/flower.png", 18, 28);
        flower2.screenX = 238 * 3;
        flower2.screenY = 42 * 3;
        roomMap.get("bathroom").mapObjects.put("flower2", flower2);
//        gp.obj[19] = new OBJ_Bathroom("flower", "/rooms/bathroom/bathroom_OBJ/flower.png",18,28);
//        gp.obj[19].screenX = 238 * 3;
//        gp.obj[19].screenY = 42 * 3;

        OBJ_Bathroom oceanPicture = new OBJ_Bathroom("ocean-picture", "/rooms/bathroom/bathroom_OBJ/ocean-picture.png", 22, 16);
        oceanPicture.screenX = 19 * 3;
        oceanPicture.screenY = 25 * 3;
        roomMap.get("bathroom").mapObjects.put("oceanPicture", oceanPicture);
//        gp.obj[20] = new OBJ_Bathroom("ocean-picture", "/rooms/bathroom/bathroom_OBJ/ocean-picture.png",22,16);
//        gp.obj[20].screenX = 19 * 3;
//        gp.obj[20].screenY = 25 * 3;

        OBJ_Bathroom blackBottle = new OBJ_Bathroom("black-bottle", "/rooms/bathroom/bathroom_OBJ/black-bottle.png", 9, 9);
        blackBottle.screenX = 104 * 3;
        blackBottle.screenY = 53 * 3;
        roomMap.get("bathroom").mapObjects.put("blackBottle", blackBottle);
//        gp.obj[21] = new OBJ_Bathroom("black-bottle", "/rooms/bathroom/bathroom_OBJ/black-bottle.png",9,9);
//        gp.obj[21].screenX = 104 * 3;
//        gp.obj[21].screenY = 53 * 3;

        OBJ_Bathroom sleepingCat = new OBJ_Bathroom("sleeping-cat", "/rooms/bathroom/bathroom_OBJ/sleeping-cat.png", 13, 11);
        sleepingCat.screenX = 197 * 3;
        sleepingCat.screenY = 154 * 3;
        roomMap.get("bathroom").mapObjects.put("sleepingCat", sleepingCat);
//        gp.obj[22] = new OBJ_Bathroom("sleeping-cat", "/rooms/bathroom/bathroom_OBJ/sleeping-cat.png",13,11);
//        gp.obj[22].screenX = 197 * 3;
//        gp.obj[22].screenY = 154 * 3;
    }
}
