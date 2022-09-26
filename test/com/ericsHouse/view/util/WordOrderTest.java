package com.ericsHouse.view.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ericsHouse.view.util.WordOrder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordOrderTest {

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
            //I tried it in a different order, and it didn't run correctly.
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