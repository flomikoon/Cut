package Test;

import main.Cut;
import main.Help;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static main.Help.lineC;
import static main.Help.lineW;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CutTest {

    private static void assertFile(String name, String name2) {
        StringBuilder content = new StringBuilder();
        StringBuilder content2 = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(name));
            String curr;
            while ((curr = br.readLine()) != null) {
                content.append(curr);
            }
        } catch (IOException ex) {
            System.out.print(ex.toString());
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(name2));
            String curr2;
            while ((curr2 = br.readLine()) != null) {
                content2.append(curr2);
            }
        } catch (IOException ex) {
            System.out.print(ex.toString());
        }
        assertEquals(content.toString(), content2.toString());
    }

    @org.junit.jupiter.api.Test
    void lineWTest() {
        assertEquals("Hello", lineW("Hello world", 1, null));
        assertEquals("world", lineW("Hello world", null, 1));
        assertEquals("no use", lineW("It’s no use to make a decision today", 1, 3));
        assertEquals("to make a decision today", lineW("It’s no use to make a decision today", null, 3));
        assertEquals("It’s no use", lineW("It’s no use to make a decision today", 3, null));
    }

    @org.junit.jupiter.api.Test
    void lineCTest() {
        assertEquals("H", lineC("Hello world", 1, null));
        assertEquals("ello world", lineC("Hello world", null, 1));
        assertEquals("t’", lineC("It’s no use to make a decision today", 1, 3));
        assertEquals("s no use to make a decision today", lineC("It’s no use to make a decision today", null, 3));
        assertEquals("It’", lineC("It’s no use to make a decision today", 3, null));
    }

    @org.junit.jupiter.api.Test
    void WriteInFileTest() {
        File out = new File("files/test1.txt");
        Help.writeClear(out);
        Help.writeInFile(out, "Hello world");
        assertFile("files/test1.txt", "testfile/input1.txt");
        File out1 = new File("files/test2.txt");
        Help.writeClear(out1);
        Help.writeInFile(out1, "It no use to make a decision today" + "\n" + "Hello world" + "\n" + "Poly");
        assertFile("files/test2.txt", "testfile/input2.txt");
    }

    @org.junit.jupiter.api.Test
    void FixStrTest() {
        assertEquals("t’", Help.fixStr(true, false, "It’s no use to make a decision today", 1, 3));
        assertEquals("I missed", Help.fixStr(false, true, "I missed my flight!", 2, null));
        assertEquals("missed my flight!", Help.fixStr(false, true, "I missed my flight!", null, 1));
        assertEquals("truck has", Help.fixStr(false, true, "The truck has stuck in the mud", 1, 3));
        assertEquals("The", Help.fixStr(true, false, "The truck has stuck in the mud", 3, null));
    }

    @org.junit.jupiter.api.Test
    void MainTest() {
        String[] str = {"cut", "-w", "-o", "files/test3.txt", "testfile/input3.txt", "-4"};
        Cut.main(str);
        assertFile("files/test3.txt", "testfile/output3-3.txt");
        String[] str1 = {"cut", "-c", "-o", "files/test4.txt", "testfile/input4.txt", "3-"};
        Cut.main(str1);
        assertFile("files/test4.txt", "testfile/output4-4.txt");
        String[] str2 = {"cut", "-w", "-o", "files/test5.txt", "testfile/input5.txt", "2-5"};
        Cut.main(str2);
        assertFile("files/test5.txt", "testfile/output5-5.txt");
    }

}