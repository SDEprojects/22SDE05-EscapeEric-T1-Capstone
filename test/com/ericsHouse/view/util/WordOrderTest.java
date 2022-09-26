package com.ericsHouse.view.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ericsHouse.view.util.WordOrder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordOrderTest {
    /**
     * Testing if in the living room if the items aren't inputted correctly
     * then it returns false, I tried a different order, and it does work.
     */

    @Test
    void generateCompareListTest() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("oranges");
        testList.add("pears");
        testList.add("emerald-earrings");
        testList.add("note");

        generateCompareList();
        assertEquals(testList,compareList);
    }

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
        assertEquals(compareList, clickedObJ);
    }
}