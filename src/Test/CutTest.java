package Test;

import Main.Help;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static Main.Help.*;
import static org.junit.jupiter.api.Assertions.*;
class CutTest {

    private static void assertFileContent(String name, String name2) {
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
        assertEquals(content.toString() , content2.toString());
    }

    @org.junit.jupiter.api.Test
    void lineWTest() {
        assertEquals("Hello" , lineW("Hello world",1 , 0));
        assertEquals("world" , lineW("Hello world",0 , 1));
        assertEquals("no use" , lineW("It’s no use to make a decision today",1 , 3));
        assertEquals("a decision today" , lineW("It’s no use to make a decision today",0 , 3));
        assertEquals("It’s no use" , lineW("It’s no use to make a decision today",3 , 0));
    }

    @org.junit.jupiter.api.Test
    void lineCTest() {
        assertEquals("H" , lineC("Hello world",1 , 0));
        assertEquals("d" , lineC("Hello world",0 , 1));
        assertEquals("t’" , lineC("It’s no use to make a decision today",1 , 3));
        assertEquals("day" , lineC("It’s no use to make a decision today",0 , 3));
        assertEquals("It’" , lineC("It’s no use to make a decision today",3 , 0));
    }

    @Test
    void WriteInFileTest() {
        File out = new File("files/test1.txt");
        Help.writeInFile(out, "Hello world");
        assertFileContent("files/test1.txt" , "testfile/input1.txt");
        File out1 = new File("files/test2.txt");
        Help.writeInFile(out1, "It no use to make a decision today" + "\n" + "Hello world" + "\n" + "Poly");
        assertFileContent("files/test2.txt" , "testfile/input2.txt");

    }

    @org.junit.jupiter.api.Test
    void rangeTest() {
        assertTrue(Arrays.equals(new int[]{3 , 0} ,range("-3") ));
        assertTrue(Arrays.equals(new int[]{1 , 3},range("1-3") ));
        assertTrue(Arrays.equals(new int[]{0 , 4},range("4-") ));
        assertFalse(Arrays.equals(new int[]{3 , 2} ,range("-3") ));
        assertTrue(Arrays.equals(new int[]{4 , 5},range("4-5") ));
        assertFalse(Arrays.equals(new int[]{0 , 2},range("4-") ));
    }

    @org.junit.jupiter.api.Test
    void FixStrTest() {

    }


}