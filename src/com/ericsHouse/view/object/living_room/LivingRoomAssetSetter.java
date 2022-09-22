package com.ericsHouse.view.object.living_room;

import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.panels.GamePanel;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class LivingRoomAssetSetter extends AssetSetter {


    public LivingRoomAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {

        OBJ_LivingRoom rug = new OBJ_LivingRoom("rug", "/rooms/living_room/living_room_OBJ/rug.png", 48, 31);
        rug.screenX = 109 * 3;
        rug.screenY = 87 * 3;
        rug.collision = false;
        roomMap.get("living-room").mapObjects.put("rug", rug);

        OBJ_LivingRoom dresser1 = new OBJ_LivingRoom("dresser", "/rooms/living_room/living_room_OBJ/dresser.png", 29, 30);
        dresser1.screenX = 14 * 3;
        dresser1.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("dresser1", dresser1);

        OBJ_LivingRoom dresser2 = new OBJ_LivingRoom("dresser", "/rooms/living_room/living_room_OBJ/dresser.png", 29, 30);
        dresser2.screenX = 223 * 3;
        dresser2.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("dresser2", dresser2);

        OBJ_LivingRoom bookshelf1 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png", 17, 29);
        bookshelf1.screenX = 43 * 3;
        bookshelf1.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf1", bookshelf1);

        OBJ_LivingRoom bookshelf2 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png", 17, 29);
        bookshelf2.screenX = 60 * 3;
        bookshelf2.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf2", bookshelf2);

        OBJ_LivingRoom bookshelf3 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png", 17, 29);
        bookshelf3.screenX = 77 * 3;
        bookshelf3.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf3", bookshelf3);

        OBJ_LivingRoom bookshelf4 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png", 17, 29);
        bookshelf4.screenX = 171 * 3;
        bookshelf4.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf4", bookshelf4);

        OBJ_LivingRoom bookshelf5 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png", 17, 29);
        bookshelf5.screenX = 188 * 3;
        bookshelf5.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf5", bookshelf5);

        OBJ_LivingRoom bookshelf6 = new OBJ_LivingRoom("bookshelf", "/rooms/living_room/living_room_OBJ/bookshelf.png", 17, 29);
        bookshelf6.screenX = 206 * 3;
        bookshelf6.screenY = 44 * 3;
        roomMap.get("living-room").mapObjects.put("bookshelf6", bookshelf6);

        OBJ_LivingRoom smallShelf1 = new OBJ_LivingRoom("smallshelf", "/rooms/living_room/living_room_OBJ/smallshelf.png", 17, 17);
        smallShelf1.screenX = 94 * 3;
        smallShelf1.screenY = 56 * 3;
        roomMap.get("living-room").mapObjects.put("smallShelf1", smallShelf1);

        OBJ_LivingRoom smallShelf2 = new OBJ_LivingRoom("smallshelf", "/rooms/living_room/living_room_OBJ/smallshelf.png", 17, 17);
        smallShelf2.screenX = 154 * 3;
        smallShelf2.screenY = 56 * 3;
        roomMap.get("living-room").mapObjects.put("smallShelf2", smallShelf2);

        OBJ_LivingRoom fireplace = new OBJ_LivingRoom("fireplace", "/rooms/living_room/living_room_OBJ/fireplace.png", 27, 30);
        fireplace.screenX = 120 * 3;
        fireplace.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("fireplace", fireplace);

        OBJ_LivingRoom flowerPot1 = new OBJ_LivingRoom("flower-pot", "/rooms/living_room/living_room_OBJ/flower-pot.png", 17, 22);
        flowerPot1.screenX = 15 * 3;
        flowerPot1.screenY = 26 * 3;
        roomMap.get("living-room").mapObjects.put("flowerPot1", flowerPot1);

        OBJ_LivingRoom flowerPot2 = new OBJ_LivingRoom("flower-pot", "/rooms/living_room/living_room_OBJ/flower-pot.png", 17, 22);
        flowerPot2.screenX = 236 * 3;
        flowerPot2.screenY = 23 * 3;
        roomMap.get("living-room").mapObjects.put("flowerPot2", flowerPot2);

        OBJ_LivingRoom selfPortrait = new OBJ_LivingRoom("self-portrait", "/rooms/living_room/living_room_OBJ/self-portrait.png", 32, 32);
        selfPortrait.screenX = 118 * 3;
        selfPortrait.screenY = 5 * 3;
        roomMap.get("living-room").mapObjects.put("selfPortrait", selfPortrait);

        OBJ_LivingRoom catStatue1 = new OBJ_LivingRoom("cat-statue", "/rooms/living_room/living_room_OBJ/cat-statue.png", 10, 14);
        catStatue1.screenX = 82 * 3;
        catStatue1.screenY = 34 * 3;
        roomMap.get("living-room").mapObjects.put("catStatue1", catStatue1);

        OBJ_LivingRoom catStatue2 = new OBJ_LivingRoom("cat-statue", "/rooms/living_room/living_room_OBJ/cat-statue.png", 10, 14);
        catStatue2.screenX = 173 * 3;
        catStatue2.screenY = 34 * 3;
        roomMap.get("living-room").mapObjects.put("catStatue2", catStatue2);

        OBJ_LivingRoom couchLeft = new OBJ_LivingRoom("couch", "/rooms/living_room/living_room_OBJ/couch-left.png", 15, 32);
        couchLeft.screenX = 79 * 3;
        couchLeft.screenY = 91 * 3;
        roomMap.get("living-room").mapObjects.put("couchLeft", couchLeft);

        OBJ_LivingRoom couchRight = new OBJ_LivingRoom("couch", "/rooms/living_room/living_room_OBJ/couch-right.png", 15, 32);
        couchRight.screenX = 169 * 3;
        couchRight.screenY = 91 * 3;
        roomMap.get("living-room").mapObjects.put("couchRight", couchRight);

        OBJ_LivingRoom coffeeTable = new OBJ_LivingRoom("coffee-table", "/rooms/living_room/living_room_OBJ/coffee-table.png", 29, 17);
        coffeeTable.screenX = 120 * 3;
        coffeeTable.screenY = 95 * 3;
        roomMap.get("living-room").mapObjects.put("coffeeTable", coffeeTable);

        OBJ_LivingRoom couchBottom = new OBJ_LivingRoom("couch", "/rooms/living_room/living_room_OBJ/bottom-couch.png", 80, 19);
        couchBottom.screenX = 94 * 3;
        couchBottom.screenY = 128 * 3;
        roomMap.get("living-room").mapObjects.put("couchBottom", couchBottom);

        OBJ_LivingRoom glassTable = new OBJ_LivingRoom("coffee-table", "/rooms/living_room/living_room_OBJ/glass-table.png", 18, 15);
        glassTable.screenX = 21 * 3;
        glassTable.screenY = 166 * 3;
        roomMap.get("living-room").mapObjects.put("glassTable", glassTable);

        OBJ_Earrings emeraldEarrings = new OBJ_Earrings("emerald-earrings", "/rooms/living_room/living_room_OBJ/emerald-earrings.png", 9, 6);
        emeraldEarrings.screenX = 26 * 3;
        emeraldEarrings.screenY = 166 * 3;
        roomMap.get("living-room").mapObjects.put("emeraldEarrings", emeraldEarrings);

        OBJ_Dog dog = new OBJ_Dog("sleeping-dog", "/rooms/living_room/living_room_OBJ/sleeping-dog.png", 11, 12);
        dog.screenX = 244 * 3;
        dog.screenY = 105 * 3;
        roomMap.get("living-room").mapObjects.put("dog", dog);

        OBJ_LivingRoom sideLamp = new OBJ_LivingRoom("side-lamp", "/rooms/living_room/living_room_OBJ/side-lamp.png", 13, 29);
        sideLamp.screenX = 79 * 3;
        sideLamp.screenY = 106 * 3;
        roomMap.get("living-room").mapObjects.put("sideLamp", sideLamp);

        OBJ_LivingRoom catCushion = new OBJ_LivingRoom("cushion-cat", "/rooms/living_room/living_room_OBJ/cushion-cat.png", 17, 19);
        catCushion.screenX = 18 * 3;
        catCushion.screenY = 73 * 3;
        roomMap.get("living-room").mapObjects.put("catCushion", catCushion);

        OBJ_LivingRoom deerPicture = new OBJ_LivingRoom("deer-picture", "/rooms/living_room/living_room_OBJ/deer-picture.png", 16, 16);
        deerPicture.screenX = 89 * 3;
        deerPicture.screenY = 16 * 3;
        roomMap.get("living-room").mapObjects.put("deerPicture", deerPicture);

        OBJ_LivingRoom dogPicture = new OBJ_LivingRoom("dog-picture", "/rooms/living_room/living_room_OBJ/dog-picture.png", 14, 16);
        dogPicture.screenX = 164 * 3;
        dogPicture.screenY = 15 * 3;
        roomMap.get("living-room").mapObjects.put("dogPicture", dogPicture);

        OBJ_LivingRoom flowerPicture = new OBJ_LivingRoom("flower-picture", "/rooms/living_room/living_room_OBJ/flower-picture.png", 8, 6);
        flowerPicture.screenX = 73 * 3;
        flowerPicture.screenY = 42 * 3;
        roomMap.get("living-room").mapObjects.put("flowerPicture", flowerPicture);

        OBJ_LivingRoom barnPicture = new OBJ_LivingRoom("barn-picture", "/rooms/living_room/living_room_OBJ/barn-picture.png", 7, 9);
        barnPicture.screenX = 161 * 3;
        barnPicture.screenY = 49 * 3;
        roomMap.get("living-room").mapObjects.put("barnPicture", barnPicture);
    }
}
