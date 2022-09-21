package com.ericsHouse.view.object.living_room;

import com.ericsHouse.view.panels.GamePanel;
import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.object.SuperObject;

import java.util.Arrays;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class LivingRoomAssetSetter extends AssetSetter {


    public LivingRoomAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {
        Arrays.fill(gp.obj, null);
        gp.obj = new SuperObject[30];

        OBJ_LivingRoom rug = new OBJ_LivingRoom("rug", "/rooms/living_room/living_room_OBJ/rug.png",48,31);
        rug.screenX = 109 * 3;
        rug.screenY = 87 * 3;
        rug.collision = false;
        roomMap.get("living-room").mapObjects.put("rug", rug);
//        gp.obj[0] = new OBJ_LivingRoom("rug", "/rooms/living_room/living_room_OBJ/rug.png",48,31);
//        gp.obj[0].screenX = 109 * 3;
//        gp.obj[0].screenY = 87 * 3;
//        gp.obj[0].collision = false;

        OBJ_LivingRoom dresser1 = new OBJ_LivingRoom("dresser", "/rooms/living_room/living_room_OBJ/dresser.png",29,30);
        dresser1.screenX = 14 * 3;
        dresser1.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("dresser1", dresser1);
//        gp.obj[1] = new OBJ_LivingRoom("dresser", "/rooms/living_room/living_room_OBJ/dresser.png",29,30);
//        gp.obj[1].screenX = 14 * 3;
//        gp.obj[1].screenY = 42 * 3;

        OBJ_LivingRoom dresser2 = new OBJ_LivingRoom("dresser", "/rooms/living_room/living_room_OBJ/dresser.png",29,30);
        dresser2.screenX = 223 * 3;
        dresser2.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("dresser2", dresser2);
//        gp.obj[2] = new OBJ_LivingRoom("dresser", "/rooms/living_room/living_room_OBJ/dresser.png",29,30);
//        gp.obj[2].screenX = 223 * 3;
//        gp.obj[2].screenY = 42 * 3;

        OBJ_LivingRoom bookshelf1 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
        bookshelf1.screenX = 43 * 3;
        bookshelf1.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf1", bookshelf1);
//        gp.obj[3] = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
//        gp.obj[3].screenX = 43 * 3;
//        gp.obj[3].screenY = 44 * 3;

        OBJ_LivingRoom bookshelf2 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
        bookshelf2.screenX = 60 * 3;
        bookshelf2.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf2", bookshelf2);
//        gp.obj[4] = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
//        gp.obj[4].screenX = 60 * 3;
//        gp.obj[4].screenY = 44 * 3;

        OBJ_LivingRoom bookshelf3 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
        bookshelf3.screenX = 77 * 3;
        bookshelf3.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf3", bookshelf3);
//        gp.obj[5] = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
//        gp.obj[5].screenX = 77 * 3;
//        gp.obj[5].screenY = 44 * 3;

        OBJ_LivingRoom bookshelf4 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
        bookshelf4.screenX = 171 * 3;
        bookshelf4.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf4", bookshelf4);
//        gp.obj[6] = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
//        gp.obj[6].screenX = 171 * 3;
//        gp.obj[6].screenY = 44 * 3;

        OBJ_LivingRoom bookshelf5 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
        bookshelf5.screenX = 188 * 3;
        bookshelf5.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf5", bookshelf5);
//        gp.obj[7] = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
//        gp.obj[7].screenX = 188 * 3;
//        gp.obj[7].screenY = 44 * 3;

        OBJ_LivingRoom bookshelf6 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
        bookshelf6.screenX = 206 * 3;
        bookshelf6.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf6", bookshelf6);
//        gp.obj[8] = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png",17,29);
//        gp.obj[8].screenX = 206 * 3;
//        gp.obj[8].screenY = 44 * 3;

        OBJ_LivingRoom smallShelf1 = new OBJ_LivingRoom("smallshelf", "/rooms/living_room/living_room_OBJ/smallshelf.png",17,17);
        smallShelf1.screenX = 94 * 3;
        smallShelf1.screenY = 56 * 3;
        roomMap.get("living-room").mapObjects.put("smallShelf1", smallShelf1);
//        gp.obj[9] = new OBJ_LivingRoom("smallshelf", "/rooms/living_room/living_room_OBJ/smallshelf.png",17,17);
//        gp.obj[9].screenX = 94 * 3;
//        gp.obj[9].screenY = 56 * 3;

        OBJ_LivingRoom smallShelf2 = new OBJ_LivingRoom("smallshelf", "/rooms/living_room/living_room_OBJ/smallshelf.png",17,17);
        smallShelf2.screenX = 154 * 3;
        smallShelf2.screenY = 56 * 3;
        roomMap.get("living-room").mapObjects.put("smallShelf2", smallShelf2);
//        gp.obj[10] = new OBJ_LivingRoom("smallshelf", "/rooms/living_room/living_room_OBJ/smallshelf.png",17,17);
//        gp.obj[10].screenX = 154 * 3;
//        gp.obj[10].screenY = 56 * 3;

        OBJ_LivingRoom fireplace = new OBJ_LivingRoom("fireplace", "/rooms/living_room/living_room_OBJ/fireplace.png",27,30);
        fireplace.screenX = 120 * 3;
        fireplace.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("fireplace", fireplace);
//        gp.obj[11] = new OBJ_LivingRoom("fireplace", "/rooms/living_room/living_room_OBJ/fireplace.png",27,30);
//        gp.obj[11].screenX = 120 * 3;
//        gp.obj[11].screenY = 42 * 3;

        OBJ_LivingRoom flowerPot1 = new OBJ_LivingRoom("flower-pot", "/rooms/living_room/living_room_OBJ/flower-pot.png",17,22);
        flowerPot1.screenX = 15 * 3;
        flowerPot1.screenY = 26 * 3;
        roomMap.get("living-room").mapObjects.put("flowerPot1", flowerPot1);
//        gp.obj[12] = new OBJ_LivingRoom("flower-pot", "/rooms/living_room/living_room_OBJ/flower-pot.png",17,22);
//        gp.obj[12].screenX = 15 * 3;
//        gp.obj[12].screenY = 26 * 3;

        OBJ_LivingRoom flowerPot2 = new OBJ_LivingRoom("flower-pot", "/rooms/living_room/living_room_OBJ/flower-pot.png",17,22);
        flowerPot2.screenX = 236 * 3;
        flowerPot2.screenY = 23 * 3;
        roomMap.get("living-room").mapObjects.put("flowerPot2", flowerPot2);
//        gp.obj[13] = new OBJ_LivingRoom("flower-pot", "/rooms/living_room/living_room_OBJ/flower-pot.png",17,22);
//        gp.obj[13].screenX = 236 * 3;
//        gp.obj[13].screenY = 23 * 3;

        OBJ_LivingRoom selfPortrait = new OBJ_LivingRoom("self-portrait", "/rooms/living_room/living_room_OBJ/self-portrait.png",32,32);
        selfPortrait.screenX = 118 * 3;
        selfPortrait.screenY = 5 * 3;
        roomMap.get("living-room").mapObjects.put("selfPortrait", selfPortrait);
//        gp.obj[14] = new OBJ_LivingRoom("self-portrait", "/rooms/living_room/living_room_OBJ/self-portrait.png",32,32);
//        gp.obj[14].screenX = 118 * 3;
//        gp.obj[14].screenY = 5 * 3;

        OBJ_LivingRoom catStatue1 = new OBJ_LivingRoom("cat-statue", "/rooms/living_room/living_room_OBJ/cat-statue.png",10,14);
        catStatue1.screenX = 82 * 3;
        catStatue1.screenY = 34 * 3;
        roomMap.get("living-room").mapObjects.put("catStatue1", catStatue1);
//        gp.obj[15] = new OBJ_LivingRoom("cat-statue", "/rooms/living_room/living_room_OBJ/cat-statue.png",10,14);
//        gp.obj[15].screenX = 82 * 3;
//        gp.obj[15].screenY = 34 * 3;

        OBJ_LivingRoom catStatue2 = new OBJ_LivingRoom("cat-statue", "/rooms/living_room/living_room_OBJ/cat-statue.png",10,14);
        catStatue2.screenX = 173 * 3;
        catStatue2.screenY = 34 * 3;
        roomMap.get("living-room").mapObjects.put("catStatue2", catStatue2);
//        gp.obj[16] = new OBJ_LivingRoom("cat-statue", "/rooms/living_room/living_room_OBJ/cat-statue.png",10,14);
//        gp.obj[16].screenX = 173 * 3;
//        gp.obj[16].screenY = 34 * 3;

        OBJ_LivingRoom couchLeft = new OBJ_LivingRoom("couch-left", "/rooms/living_room/living_room_OBJ/couch-left.png",15,32);
        couchLeft.screenX = 79 * 3;
        couchLeft.screenY = 91 * 3;
        roomMap.get("living-room").mapObjects.put("couchLeft", couchLeft);
//        gp.obj[17] = new OBJ_LivingRoom("couch-left", "/rooms/living_room/living_room_OBJ/couch-left.png",15,32);
//        gp.obj[17].screenX = 79 * 3;
//        gp.obj[17].screenY = 91 * 3;

        OBJ_LivingRoom couchRight = new OBJ_LivingRoom("couch-right", "/rooms/living_room/living_room_OBJ/couch-right.png",15,32);
        couchRight.screenX = 169 * 3;
        couchRight.screenY = 91 * 3;
        roomMap.get("living-room").mapObjects.put("couchRight", couchRight);
//        gp.obj[18] = new OBJ_LivingRoom("couch-right", "/rooms/living_room/living_room_OBJ/couch-right.png",15,32);
//        gp.obj[18].screenX = 169 * 3;
//        gp.obj[18].screenY = 91 * 3;

        OBJ_LivingRoom coffeeTable = new OBJ_LivingRoom("coffee-table", "/rooms/living_room/living_room_OBJ/coffee-table.png",29,17);
        coffeeTable.screenX = 120 * 3;
        coffeeTable.screenY = 95 * 3;
        roomMap.get("living-room").mapObjects.put("coffeeTable", coffeeTable);
//        gp.obj[19] = new OBJ_LivingRoom("coffee-table", "/rooms/living_room/living_room_OBJ/coffee-table.png",29,17);
//        gp.obj[19].screenX = 120 * 3;
//        gp.obj[19].screenY = 95 * 3;

        OBJ_LivingRoom couchBottom = new OBJ_LivingRoom("bottom-couch", "/rooms/living_room/living_room_OBJ/bottom-couch.png",80,19);
        couchBottom.screenX = 94 * 3;
        couchBottom.screenY = 128 * 3;
        roomMap.get("living-room").mapObjects.put("couchBottom", couchBottom);
//        gp.obj[20] = new OBJ_LivingRoom("bottom-couch", "/rooms/living_room/living_room_OBJ/bottom-couch.png",80,19);
//        gp.obj[20].screenX = 94 * 3;
//        gp.obj[20].screenY = 128 * 3;

        OBJ_LivingRoom glassTable = new OBJ_LivingRoom("glass-table", "/rooms/living_room/living_room_OBJ/glass-table.png",18,15);
        glassTable.screenX = 21 * 3;
        glassTable.screenY = 166 * 3;
        roomMap.get("living-room").mapObjects.put("glassTable", glassTable);
//        gp.obj[21] = new OBJ_LivingRoom("glass-table", "/rooms/living_room/living_room_OBJ/glass-table.png",18,15);
//        gp.obj[21].screenX = 21 * 3;
//        gp.obj[21].screenY = 166 * 3;

        OBJ_Earrings emeraldEarrings = new OBJ_Earrings("emerald-earrings", "/rooms/living_room/living_room_OBJ/emerald-earrings.png",9,6);
        emeraldEarrings.screenX = 26 * 3;
        emeraldEarrings.screenY = 166 * 3;
        roomMap.get("living-room").mapObjects.put("emeraldEarrings", emeraldEarrings);
//        gp.obj[22] = new OBJ_Earrings("emerald-earrings", "/rooms/living_room/living_room_OBJ/emerald-earrings.png",9,6);
//        gp.obj[22].screenX = 26 * 3;
//        gp.obj[22].screenY = 166 * 3;

        OBJ_LivingRoom sleepingDog = new OBJ_LivingRoom("sleeping-dog", "/rooms/living_room/living_room_OBJ/sleeping-dog.png",11,12);
        sleepingDog.screenX = 244 * 3;
        sleepingDog.screenY = 166 * 3;
        roomMap.get("living-room").mapObjects.put("sleepingDog", sleepingDog);
//        gp.obj[23] = new OBJ_LivingRoom("sleeping-dog", "/rooms/living_room/living_room_OBJ/sleeping-dog.png",11,12);
//        gp.obj[23].screenX = 244 * 3;
//        gp.obj[23].screenY = 116 * 3;
        gp.obj[23] = new OBJ_Dog("sleeping-dog", "/rooms/living_room/living_room_OBJ/sleeping-dog.png",11,12);
        gp.obj[23].screenX = 244 * 3;
        gp.obj[23].screenY = 105 * 3;

        OBJ_LivingRoom sideLamp = new OBJ_LivingRoom("side-lamp", "/rooms/living_room/living_room_OBJ/side-lamp.png",13,29);
        sideLamp.screenX = 79 * 3;
        sideLamp.screenY = 106 * 3;
        roomMap.get("living-room").mapObjects.put("sideLamp", sideLamp);
//        gp.obj[24] = new OBJ_LivingRoom("side-lamp", "/rooms/living_room/living_room_OBJ/side-lamp.png",13,29);
//        gp.obj[24].screenX = 79 * 3;
//        gp.obj[24].screenY = 106 * 3;

        OBJ_LivingRoom catCushion = new OBJ_LivingRoom("cushion-cat", "/rooms/living_room/living_room_OBJ/cushion-cat.png",17,19);
        catCushion.screenX = 18 * 3;
        catCushion.screenY = 73 * 3;
        roomMap.get("living-room").mapObjects.put("catCushion", catCushion);
//        gp.obj[25] = new OBJ_LivingRoom("cushion-cat", "/rooms/living_room/living_room_OBJ/cushion-cat.png",17,19);
//        gp.obj[25].screenX = 18 * 3;
//        gp.obj[25].screenY = 73 * 3;

        OBJ_LivingRoom deerPicture = new OBJ_LivingRoom("deer-picture", "/rooms/living_room/living_room_OBJ/deer-picture.png",16,16);
        deerPicture.screenX = 89 * 3;
        deerPicture.screenY = 16 * 3;
        roomMap.get("living-room").mapObjects.put("deerPicture", deerPicture);
//        gp.obj[26] = new OBJ_LivingRoom("deer-picture", "/rooms/living_room/living_room_OBJ/deer-picture.png",16,16);
//        gp.obj[26].screenX = 89 * 3;
//        gp.obj[26].screenY = 16 * 3;

        OBJ_LivingRoom dogPicture = new OBJ_LivingRoom("dog-picture", "/rooms/living_room/living_room_OBJ/dog-picture.png",14,16);
        dogPicture.screenX = 164 * 3;
        dogPicture.screenY = 15 * 3;
        roomMap.get("living-room").mapObjects.put("dogPicture", dogPicture);
//        gp.obj[27] = new OBJ_LivingRoom("dog-picture", "/rooms/living_room/living_room_OBJ/dog-picture.png",14,16);
//        gp.obj[27].screenX = 164 * 3;
//        gp.obj[27].screenY = 15 * 3;

        OBJ_LivingRoom flowerPicture = new OBJ_LivingRoom("flower-picture", "/rooms/living_room/living_room_OBJ/flower-picture.png",8,6);
        flowerPicture.screenX = 73 * 3;
        flowerPicture.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("flowerPicture", flowerPicture);
//        gp.obj[28] = new OBJ_LivingRoom("flower-picture", "/rooms/living_room/living_room_OBJ/flower-picture.png",8,6);
//        gp.obj[28].screenX = 73 * 3;
//        gp.obj[28].screenY = 42 * 3;

        OBJ_LivingRoom barnPicture = new OBJ_LivingRoom("barn-picture", "/rooms/living_room/living_room_OBJ/barn-picture.png",7,9);
        barnPicture.screenX = 161 * 3;
        barnPicture.screenY = 49 * 3;
        roomMap.get("living-room").mapObjects.put("barnPicture", barnPicture);
//        gp.obj[29] = new OBJ_LivingRoom("barn-picture", "/rooms/living_room/living_room_OBJ/barn-picture.png",7,9);
//        gp.obj[29].screenX = 161 * 3;
//        gp.obj[29].screenY = 49 * 3;
    }
}
