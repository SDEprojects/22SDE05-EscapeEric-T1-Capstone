package com.ericsHouse.view.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.ericsHouse.view.util.WordOrder.clickedObJ;
import static com.ericsHouse.view.util.WordOrder.compareList;

class WordOrderTest {
    @Test
    void checkLists() {
        compareList.add("oranges");
        compareList.add("pears");
        compareList.add("emerald-earrings");
        compareList.add("note");
        clickedObJ.add("oranges");
        clickedObJ.add("pears");
        clickedObJ.add("emerald-earrings");
        clickedObJ.add("note");
        Assertions.assertEquals(compareList, clickedObJ);
    }
}