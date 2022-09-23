package com.ericsHouse.jsonParser;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonParserTest {

    @Test
    void getFileFromResourceAsStream() {

        // File exists
        InputStream is = JsonParser.getFileFromResourceAsStream("roomPrompts.json");
        assertNotNull(is);
        // File doesn't exist
        assertThrows(IllegalArgumentException.class, () -> JsonParser.getFileFromResourceAsStream("fileDontExist.json"));
    }
}