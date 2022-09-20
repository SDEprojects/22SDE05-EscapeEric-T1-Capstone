package view.object.bedroom;

import view.GamePanel;
import view.object.AssetSetter;
import view.object.SuperObject;
import view.object.kitchen.OBJ_Kitchen;
import view.object.living_room.OBJ_LivingRoom;

import java.util.Arrays;

public class BedroomAssetSetter extends AssetSetter {


    public BedroomAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {
        Arrays.fill(gp.obj, null);
        gp.obj = new OBJ_Bedroom[34];

        gp.obj[0] = new OBJ_Bedroom("side-table-girl", "/rooms/bedroom/bedroom_OBJ/side-table-girl.png",14,21);
        gp.obj[0].screenX = 22 * 3;
        gp.obj[0].screenY = 50 * 3;

        gp.obj[1] = new OBJ_Bedroom("side-table-girl", "/rooms/bedroom/bedroom_OBJ/side-table-girl.png",14,21);
        gp.obj[1].screenX = 51 * 3;
        gp.obj[1].screenY = 50 * 3;

        gp.obj[2] = new OBJ_Bedroom("bed", "/rooms/bedroom/bedroom_OBJ/girl-bed.png",15,26);
        gp.obj[2].screenX = 36 * 3;
        gp.obj[2].screenY = 56 * 3;

        gp.obj[3] = new OBJ_Bedroom("toys", "/rooms/bedroom/bedroom_OBJ/girl-toys.png",16,13);
        gp.obj[3].screenX = 66 * 3;
        gp.obj[3].screenY = 58 * 3;

        gp.obj[4] = new OBJ_Bedroom("toys", "/rooms/bedroom/bedroom_OBJ/boy-toys.png",16,13);
        gp.obj[4].screenX = 149 * 3;
        gp.obj[4].screenY = 56 * 3;

        gp.obj[5] = new OBJ_Bedroom("door", "/rooms/bedroom/bedroom_OBJ/door.png",24,30);
        gp.obj[5].screenX = 219 * 3;
        gp.obj[5].screenY = 35 * 3;

        gp.obj[6] = new OBJ_Bedroom("bed", "/rooms/bedroom/bedroom_OBJ/boy-bed.png",15,27);
        gp.obj[6].screenX = 180 * 3;
        gp.obj[6].screenY = 55 * 3;

        gp.obj[7] = new OBJ_Bedroom("bird", "/rooms/bedroom/bedroom_OBJ/bird.png",15,33);
        gp.obj[7].screenX = 19 * 3;
        gp.obj[7].screenY = 151 * 3;
        gp.obj[7].riddleItem = true;

        gp.obj[8] = new OBJ_Bedroom("car-mat", "/rooms/bedroom/bedroom_OBJ/car-mat.png",34,18);
        gp.obj[8].screenX = 159 * 3;
        gp.obj[8].screenY = 165 * 3;
        gp.obj[8].collision = false;

        gp.obj[9] = new OBJ_Bedroom("heart-rug", "/rooms/bedroom/bedroom_OBJ/heart-rug.png",32,26);
        gp.obj[9].screenX = 99 * 3;
        gp.obj[9].screenY = 109 * 3;
        gp.obj[9].collision = false;

        gp.obj[10] = new OBJ_Bedroom("play-desk", "/rooms/bedroom/bedroom_OBJ/play-desk.png",36,17);
        gp.obj[10].screenX = 201 * 3;
        gp.obj[10].screenY = 152 * 3;

        gp.obj[11] = new OBJ_Bedroom("play-chair", "/rooms/bedroom/bedroom_OBJ/play-chair.png",10,16);
        gp.obj[11].screenX = 216 * 3;
        gp.obj[11].screenY = 135 * 3;

        gp.obj[12] = new OBJ_Bedroom("cloud-plush", "/rooms/bedroom/bedroom_OBJ/cloud-plush.png",18,12);
        gp.obj[12].screenX = 218 * 3;
        gp.obj[12].screenY = 146 * 3;

        gp.obj[13] = new OBJ_Bedroom("car-toy", "/rooms/bedroom/bedroom_OBJ/car-toy.png",18,14);
        gp.obj[13].screenX = 182 * 3;
        gp.obj[13].screenY = 169 * 3;
        gp.obj[13].riddleItem = true;

        gp.obj[14] = new OBJ_Bedroom("football", "/rooms/bedroom/bedroom_OBJ/football.png",15,10);
        gp.obj[14].screenX = 191 * 3;
        gp.obj[14].screenY = 83 * 3;

        gp.obj[15] = new OBJ_Bedroom("side-table-boy", "/rooms/bedroom/bedroom_OBJ/side-table-boy.png",14,20);
        gp.obj[15].screenX = 166 * 3;
        gp.obj[15].screenY = 50 * 3;

        gp.obj[16] = new OBJ_Bedroom("side-table-boy", "/rooms/bedroom/bedroom_OBJ/side-table-boy.png",14,20);
        gp.obj[16].screenX = 195 * 3;
        gp.obj[16].screenY = 50 * 3;

        gp.obj[17] = new OBJ_Bedroom("white-chest", "/rooms/bedroom/bedroom_OBJ/white-chest.png",28,17);
        gp.obj[17].screenX = 103 * 3;
        gp.obj[17].screenY = 52 * 3;

        gp.obj[18] = new OBJ_Bedroom("dragon-plush", "/rooms/bedroom/bedroom_OBJ/dragon-plush.png",13,16);
        gp.obj[18].screenX = 66 * 3;
        gp.obj[18].screenY = 48 * 3;

        gp.obj[19] = new OBJ_Bedroom("giraffe-plush", "/rooms/bedroom/bedroom_OBJ/giraffe-plush.png",15,16);
        gp.obj[19].screenX = 149 * 3;
        gp.obj[19].screenY = 42 * 3;

        gp.obj[20] = new OBJ_Bedroom("stack-toy", "/rooms/bedroom/bedroom_OBJ/stack-toy.png",16,14);
        gp.obj[20].screenX = 38 * 3;
        gp.obj[20].screenY = 170 * 3;

        gp.obj[21] = new OBJ_Bedroom("sketch-toy", "/rooms/bedroom/bedroom_OBJ/sketch-toy.png",18,15);
        gp.obj[21].screenX = 228 * 3;
        gp.obj[21].screenY = 170 * 3;

        gp.obj[22] = new OBJ_Bedroom("rocket-plush", "/rooms/bedroom/bedroom_OBJ/rocket-plush.png",11,17);
        gp.obj[22].screenX = 206 * 3;
        gp.obj[22].screenY = 141 * 3;

        gp.obj[23] = new OBJ_Bedroom("blocks", "/rooms/bedroom/bedroom_OBJ/blocks.png",19,18);
        gp.obj[23].screenX = 118 * 3;
        gp.obj[23].screenY = 102 * 3;

        gp.obj[24] = new OBJ_Bedroom("bunny-picture", "/rooms/bedroom/bedroom_OBJ/bunny-picture.png",24,24);
        gp.obj[24].screenX = 30 * 3;
        gp.obj[24].screenY = 14 * 3;

        gp.obj[25] = new OBJ_Bedroom("dino-picture", "/rooms/bedroom/bedroom_OBJ/dino-picture.png",23,22);
        gp.obj[25].screenX = 177 * 3;
        gp.obj[25].screenY = 17 * 3;

        gp.obj[26] = new OBJ_Bedroom("cat-plushie", "/rooms/bedroom/bedroom_OBJ/cat-plushie.png",13,13);
        gp.obj[26].screenX = 104 * 3;
        gp.obj[26].screenY = 43 * 3;

        gp.obj[27] = new OBJ_Bedroom("penguin-plushie", "/rooms/bedroom/bedroom_OBJ/penguin-plushie.png",13,13);
        gp.obj[27].screenX = 116 * 3;
        gp.obj[27].screenY = 42 * 3;

        gp.obj[28] = new OBJ_Bedroom("star-plushie", "/rooms/bedroom/bedroom_OBJ/star-plushie.png",11,10);
        gp.obj[28].screenX = 124 * 3;
        gp.obj[28].screenY = 60 * 3;

        gp.obj[29] = new OBJ_Bedroom("star-plushie", "/rooms/bedroom/bedroom_OBJ/star-plushie.png",11,10);
        gp.obj[29].screenX = 99 * 3;
        gp.obj[29].screenY = 60 * 3;

        gp.obj[30] = new OBJ_Bedroom("bear-plushie", "/rooms/bedroom/bedroom_OBJ/bear-plushie.png",14,14);
        gp.obj[30].screenX = 110 * 3;
        gp.obj[30].screenY = 58 * 3;
        gp.obj[30].riddleItem = true;
    }
}
