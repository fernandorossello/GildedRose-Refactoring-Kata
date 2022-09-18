package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoldenMasterTest {

    private PrintStream toRestore;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        toRestore = System.out;
        System.setOut(stream);
    }

    @AfterEach
    void tearDown(){
        System.setOut(toRestore);
    }

    @Test
    void goldenMasterTest() throws IOException {
        TexttestFixture.main(new String[]{"100"});

        assertEquals(TestResourceUtils.readFile("expectedResult100Runs"), outputStream.toString());
    }
}
