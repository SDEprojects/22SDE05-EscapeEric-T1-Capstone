package view.object.bathroom;

import view.GamePanel;
import view.object.AssetSetter;
import view.object.SuperObject;
import view.object.kitchen.OBJ_Kitchen;

import java.io.InputStream;
import java.util.Arrays;

public class BathroomAssetSetter extends AssetSetter {


    public BathroomAssetSetter(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setObject() {
        Arrays.fill(gp.obj, null);
        gp.obj = new SuperObject[24];

        gp.obj[0] = new OBJ_Bathroom("bathtub", "/rooms/bathroom/bathroom_OBJ/bathtub.png",31,32);
        gp.obj[0].screenX = 4 * 3;
        gp.obj[0].screenY = 104 * 3;

        gp.obj[1] = new OBJ_Bathroom("toilet", "/rooms/bathroom/bathroom_OBJ/toilet.png",13,22);
        gp.obj[1].screenX = 23 * 3;
        gp.obj[1].screenY = 47 * 3;

        gp.obj[2] = new OBJ_Bathroom("seat", "/rooms/bathroom/bathroom_OBJ/seat.png",17,16);
        gp.obj[2].screenX = 101 * 3;
        gp.obj[2].screenY = 56 * 3;

        gp.obj[3] = new OBJ_Bathroom("towel-holder", "/rooms/bathroom/bathroom_OBJ/towel-holder.png",18,12);
        gp.obj[3].screenX = 101 * 3;
        gp.obj[3].screenY = 34 * 3;

        gp.obj[4] = new OBJ_Bathroom("towel-holder", "/rooms/bathroom/bathroom_OBJ/towel-holder.png",18,12);
        gp.obj[4].screenX = 176 * 3;
        gp.obj[4].screenY = 35 * 3;

        gp.obj[5] = new OBJ_Bathroom("wall-mirror", "/rooms/bathroom/bathroom_OBJ/wall-mirror.png",11,13);
        gp.obj[5].screenX = 128 * 3;
        gp.obj[5].screenY = 28 * 3;

        gp.obj[6] = new OBJ_Bathroom("wall-mirror", "/rooms/bathroom/bathroom_OBJ/wall-mirror.png",11,13);
        gp.obj[6].screenX = 156 * 3;
        gp.obj[6].screenY = 28 * 3;

        gp.obj[7] = new OBJ_Bathroom("david-mirror", "/rooms/bathroom/bathroom_OBJ/david-mirror.png",22,39);
        gp.obj[7].screenX = 203 * 3;
        gp.obj[7].screenY = 25 * 3;

        gp.obj[8] = new OBJ_Bathroom("bathroom-sink", "/rooms/bathroom/bathroom_OBJ/bathroom-sink.png",54,30);
        gp.obj[8].screenX = 120 * 3;
        gp.obj[8].screenY = 37 * 3;

        gp.obj[9] = new OBJ_Bathroom("shelves", "/rooms/bathroom/bathroom_OBJ/shelves.png",32,34);
        gp.obj[9].screenX = 67 * 3;
        gp.obj[9].screenY = 31 * 3;

        gp.obj[10] = new OBJ_Bathroom("green-bottle", "/rooms/bathroom/bathroom_OBJ/green-bottle.png",7,9);
        gp.obj[10].screenX = 23 * 3;
        gp.obj[10].screenY = 43 * 3;

        gp.obj[11] = new OBJ_Bathroom("towel-pile-1", "/rooms/bathroom/bathroom_OBJ/towel-pile-1.png",16,14);
        gp.obj[11].screenX = 5 * 3;
        gp.obj[11].screenY = 90 * 3;

        gp.obj[12] = new OBJ_Bathroom("towel-pile-1", "/rooms/bathroom/bathroom_OBJ/towel-pile-1.png",16,14);
        gp.obj[12].screenX = 203 * 3;
        gp.obj[12].screenY = 162 * 3;

        gp.obj[13] = new OBJ_Bathroom("towel-pile-2", "/rooms/bathroom/bathroom_OBJ/towel-pile-2.png",16,11);
        gp.obj[13].screenX = 186* 3;
        gp.obj[13].screenY = 161 * 3;

        gp.obj[14] = new OBJ_Bathroom("towel-pile-3", "/rooms/bathroom/bathroom_OBJ/towel-pile-3.png",16,16);
        gp.obj[14].screenX = 198* 3;
        gp.obj[14].screenY = 145 * 3;

        gp.obj[15] = new OBJ_Bathroom("washer-dryer", "/rooms/bathroom/bathroom_OBJ/washer-dryer.png",32,23);
        gp.obj[15].screenX = 219* 3;
        gp.obj[15].screenY = 139 * 3;

        gp.obj[16] = new OBJ_Bathroom("rug", "/rooms/bathroom/bathroom_OBJ/rug.png",47,32);
        gp.obj[16].screenX = 103 * 3;
        gp.obj[16].screenY = 108 * 3;
        gp.obj[16].collision = false;

        gp.obj[17] = new OBJ_Bathroom("toothbrush", "/rooms/bathroom/bathroom_OBJ/toothbrush.png",8,8);
        gp.obj[17].screenX = 143 * 3;
        gp.obj[17].screenY = 31 * 3;

        gp.obj[18] = new OBJ_Bathroom("flower", "/rooms/bathroom/bathroom_OBJ/flower.png",18,28);
        gp.obj[18].screenX = 5 * 3;
        gp.obj[18].screenY = 42 * 3;

        gp.obj[19] = new OBJ_Bathroom("flower", "/rooms/bathroom/bathroom_OBJ/flower.png",18,28);
        gp.obj[19].screenX = 238 * 3;
        gp.obj[19].screenY = 42 * 3;

        gp.obj[20] = new OBJ_Bathroom("ocean-picture", "/rooms/bathroom/bathroom_OBJ/ocean-picture.png",22,16);
        gp.obj[20].screenX = 19 * 3;
        gp.obj[20].screenY = 25 * 3;

        gp.obj[21] = new OBJ_Bathroom("black-bottle", "/rooms/bathroom/bathroom_OBJ/black-bottle.png",9,9);
        gp.obj[21].screenX = 104 * 3;
        gp.obj[21].screenY = 53 * 3;

        gp.obj[22] = new OBJ_Bathroom("sleeping-cat", "/rooms/bathroom/bathroom_OBJ/sleeping-cat.png",13,11);
        gp.obj[22].screenX = 197 * 3;
        gp.obj[22].screenY = 154 * 3;

    }
}
