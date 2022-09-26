package com.ericsHouse.view.object.bedroom;

import com.ericsHouse.view.object.AssetSetter;
import com.ericsHouse.view.panels.GamePanel;

import static com.ericsHouse.rooms.RoomMap.roomMap;

public class BedroomAssetSetter extends AssetSetter {


    public BedroomAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {

        OBJ_Bedroom sideTableGirl1 = new OBJ_Bedroom("side-table-girl", "/rooms/bedroom/bedroom_OBJ/side-table-girl.png", 14, 21);
        sideTableGirl1.screenX = 22 * 3;
        sideTableGirl1.screenY = 50 * 3;
        roomMap.get("bedroom").mapObjects.put("sideTableGirl1", sideTableGirl1);

        OBJ_Bedroom sideTableGirl2 = new OBJ_Bedroom("side-table-girl", "/rooms/bedroom/bedroom_OBJ/side-table-girl.png", 14, 21);
        sideTableGirl2.screenX = 51 * 3;
        sideTableGirl2.screenY = 50 * 3;
        roomMap.get("bedroom").mapObjects.put("sideTableGirl2", sideTableGirl2);

        OBJ_Bedroom bed1 = new OBJ_Bedroom("bed", "/rooms/bedroom/bedroom_OBJ/girl-bed.png", 15, 26);
        bed1.screenX = 36 * 3;
        bed1.screenY = 56 * 3;
        roomMap.get("bedroom").mapObjects.put("bed1", bed1);

        OBJ_Bedroom toys1 = new OBJ_Bedroom("toys", "/rooms/bedroom/bedroom_OBJ/girl-toys.png", 16, 13);
        toys1.screenX = 66 * 3;
        toys1.screenY = 58 * 3;
        roomMap.get("bedroom").mapObjects.put("toys1", toys1);

        OBJ_Bedroom toys2 = new OBJ_Bedroom("toys", "/rooms/bedroom/bedroom_OBJ/boy-toys.png", 16, 13);
        toys2.screenX = 149 * 3;
        toys2.screenY = 56 * 3;
        roomMap.get("bedroom").mapObjects.put("toys2", toys2);

        OBJ_Bedroom door = new OBJ_Bedroom("door", "/rooms/bedroom/bedroom_OBJ/door.png", 24, 30);
        door.screenX = 219 * 3;
        door.screenY = 35 * 3;
        roomMap.get("bedroom").mapObjects.put("door", door);

        OBJ_Bedroom bed2 = new OBJ_Bedroom("bed", "/rooms/bedroom/bedroom_OBJ/boy-bed.png", 15, 27);
        bed2.screenX = 180 * 3;
        bed2.screenY = 55 * 3;
        roomMap.get("bedroom").mapObjects.put("bed", bed2);

        OBJ_Bird bird = new OBJ_Bird("bird", "/rooms/bedroom/bedroom_OBJ/bird.png", 15, 33);
        bird.screenX = 19 * 3;
        bird.screenY = 151 * 3;
        bird.riddleItem = true;
        roomMap.get("bedroom").mapObjects.put("bird", bird);

        OBJ_Bedroom carMat = new OBJ_Bedroom("car-mat", "/rooms/bedroom/bedroom_OBJ/car-mat.png", 34, 18);
        carMat.screenX = 159 * 3;
        carMat.screenY = 165 * 3;
        carMat.collision = false;
        roomMap.get("bedroom").mapObjects.put("carMat", carMat);

        OBJ_Bedroom heartRug = new OBJ_Bedroom("heart-rug", "/rooms/bedroom/bedroom_OBJ/heart-rug.png", 32, 26);
        heartRug.screenX = 99 * 3;
        heartRug.screenY = 109 * 3;
        heartRug.collision = false;
        roomMap.get("bedroom").mapObjects.put("heartRug", heartRug);

        OBJ_Bedroom playDesk = new OBJ_Bedroom("play-desk", "/rooms/bedroom/bedroom_OBJ/play-desk.png", 36, 17);
        playDesk.screenX = 201 * 3;
        playDesk.screenY = 152 * 3;
        roomMap.get("bedroom").mapObjects.put("playDesk", playDesk);

        OBJ_Bedroom playChair = new OBJ_Bedroom("play-chair", "/rooms/bedroom/bedroom_OBJ/play-chair.png", 10, 16);
        playChair.screenX = 216 * 3;
        playChair.screenY = 135 * 3;
        roomMap.get("bedroom").mapObjects.put("playChair", playChair);

        OBJ_Bedroom cloudPlush = new OBJ_Bedroom("cloud-plush", "/rooms/bedroom/bedroom_OBJ/cloud-plush.png", 18, 12);
        cloudPlush.screenX = 218 * 3;
        cloudPlush.screenY = 146 * 3;
        roomMap.get("bedroom").mapObjects.put("cloudPlush", cloudPlush);

        OBJ_Bedroom carToy = new OBJ_Bedroom("car-toy", "/rooms/bedroom/bedroom_OBJ/car-toy.png", 18, 14);
        carToy.screenX = 182 * 3;
        carToy.screenY = 169 * 3;
        carToy.riddleItem = true;
        roomMap.get("bedroom").mapObjects.put("carToy", carToy);

        OBJ_Bedroom football = new OBJ_Bedroom("football", "/rooms/bedroom/bedroom_OBJ/football.png", 15, 10);
        football.screenX = 191 * 3;
        football.screenY = 83 * 3;
        roomMap.get("bedroom").mapObjects.put("football", football);

        OBJ_Bedroom sideTableBoy1 = new OBJ_Bedroom("side-table-boy", "/rooms/bedroom/bedroom_OBJ/side-table-boy.png", 14, 20);
        sideTableBoy1.screenX = 166 * 3;
        sideTableBoy1.screenY = 50 * 3;
        roomMap.get("bedroom").mapObjects.put("sideTableBoy1", sideTableBoy1);

        OBJ_Bedroom sideTableBoy2 = new OBJ_Bedroom("side-table-boy", "/rooms/bedroom/bedroom_OBJ/side-table-boy.png", 14, 20);
        sideTableBoy2.screenX = 195 * 3;
        sideTableBoy2.screenY = 50 * 3;
        roomMap.get("bedroom").mapObjects.put("sideTableBoy2", sideTableBoy2);

        OBJ_Bedroom whiteChest = new OBJ_Bedroom("white-chest", "/rooms/bedroom/bedroom_OBJ/white-chest.png", 28, 17);
        whiteChest.screenX = 103 * 3;
        whiteChest.screenY = 52 * 3;
        roomMap.get("bedroom").mapObjects.put("whiteChest", whiteChest);

        OBJ_Bedroom dragonPlush = new OBJ_Bedroom("dragon-plush", "/rooms/bedroom/bedroom_OBJ/dragon-plush.png", 13, 16);
        dragonPlush.screenX = 66 * 3;
        dragonPlush.screenY = 48 * 3;
        roomMap.get("bedroom").mapObjects.put("dragonPlush", dragonPlush);

        OBJ_Bedroom giraffePlush = new OBJ_Bedroom("giraffe-plush", "/rooms/bedroom/bedroom_OBJ/giraffe-plush.png", 15, 16);
        giraffePlush.screenX = 149 * 3;
        giraffePlush.screenY = 42 * 3;
        roomMap.get("bedroom").mapObjects.put("giraffePlush", giraffePlush);

        OBJ_Bedroom stackToy = new OBJ_Bedroom("stack-toy", "/rooms/bedroom/bedroom_OBJ/stack-toy.png", 16, 14);
        stackToy.screenX = 38 * 3;
        stackToy.screenY = 170 * 3;
        roomMap.get("bedroom").mapObjects.put("stackToy", stackToy);

        OBJ_Bedroom sketchToy = new OBJ_Bedroom("sketch-toy", "/rooms/bedroom/bedroom_OBJ/sketch-toy.png", 18, 15);
        sketchToy.screenX = 228 * 3;
        sketchToy.screenY = 170 * 3;
        roomMap.get("bedroom").mapObjects.put("sketchToy", sketchToy);

        OBJ_Bedroom rocketPlush = new OBJ_Bedroom("rocket-plush", "/rooms/bedroom/bedroom_OBJ/rocket-plush.png", 11, 17);
        rocketPlush.screenX = 206 * 3;
        rocketPlush.screenY = 141 * 3;
        roomMap.get("bedroom").mapObjects.put("rocketPlush", rocketPlush);

        OBJ_Bedroom blocks = new OBJ_Bedroom("blocks", "/rooms/bedroom/bedroom_OBJ/blocks.png", 19, 18);
        blocks.screenX = 118 * 3;
        blocks.screenY = 102 * 3;
        roomMap.get("bedroom").mapObjects.put("blocks", blocks);

        OBJ_Bedroom bunnyPicture = new OBJ_Bedroom("bunny-picture", "/rooms/bedroom/bedroom_OBJ/bunny-picture.png", 24, 24);
        bunnyPicture.screenX = 30 * 3;
        bunnyPicture.screenY = 14 * 3;
        roomMap.get("bedroom").mapObjects.put("bunnyPicture", bunnyPicture);

        OBJ_Bedroom dinoPicture = new OBJ_Bedroom("dino-picture", "/rooms/bedroom/bedroom_OBJ/dino-picture.png", 23, 22);
        dinoPicture.screenX = 177 * 3;
        dinoPicture.screenY = 17 * 3;
        roomMap.get("bedroom").mapObjects.put("dinoPicture", dinoPicture);

        OBJ_Bedroom catPlushie = new OBJ_Bedroom("cat-plushie", "/rooms/bedroom/bedroom_OBJ/cat-plushie.png", 13, 13);
        catPlushie.screenX = 104 * 3;
        catPlushie.screenY = 43 * 3;
        roomMap.get("bedroom").mapObjects.put("catPlushie", catPlushie);

        OBJ_Bedroom penguinPlushie = new OBJ_Bedroom("penguin-plushie", "/rooms/bedroom/bedroom_OBJ/penguin-plushie.png", 13, 13);
        penguinPlushie.screenX = 116 * 3;
        penguinPlushie.screenY = 42 * 3;
        roomMap.get("bedroom").mapObjects.put("penguinPlushie", penguinPlushie);

        OBJ_Bedroom starPlushie1 = new OBJ_Bedroom("star-plushie", "/rooms/bedroom/bedroom_OBJ/star-plushie.png", 11, 10);
        starPlushie1.screenX = 124 * 3;
        starPlushie1.screenY = 60 * 3;
        roomMap.get("bedroom").mapObjects.put("starPlushie1", starPlushie1);

        OBJ_Bedroom starPlushie2 = new OBJ_Bedroom("star-plushie", "/rooms/bedroom/bedroom_OBJ/star-plushie.png", 11, 10);
        starPlushie2.screenX = 99 * 3;
        starPlushie2.screenY = 60 * 3;
        roomMap.get("bedroom").mapObjects.put("starPlushie2", starPlushie2);

        OBJ_Bedroom bearPlushie = new OBJ_Bedroom("bear-plushie", "/rooms/bedroom/bedroom_OBJ/bear-plushie.png", 14, 14);
        bearPlushie.screenX = 110 * 3;
        bearPlushie.screenY = 58 * 3;
        bearPlushie.riddleItem = true;
        roomMap.get("bedroom").mapObjects.put("bearPlushie", bearPlushie);

        OBJ_Aluminum aluminum = new OBJ_Aluminum("aluminum", "/rooms/bedroom/bedroom_OBJ/aluminum.png", 10, 10);
        aluminum.screenX = 26 * 3;
        aluminum.screenY = 63 * 3;
        roomMap.get("bedroom").mapObjects.put("aluminum", aluminum);
    }
}
