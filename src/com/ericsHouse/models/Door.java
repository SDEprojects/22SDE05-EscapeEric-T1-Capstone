package com.ericsHouse.models;

public class Door {

    private boolean locked = true;

    public Door() {
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
