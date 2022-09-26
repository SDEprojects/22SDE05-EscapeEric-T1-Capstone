package com.ericsHouse.view.object;

import com.ericsHouse.view.panels.GamePanel;

/**
 * Abstract parent class of all the asset setters for each room
 */
public abstract class AssetSetter {

    public GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

    }

}
