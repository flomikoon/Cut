package Test;

import static Main.Help.lineC;
import static Main.Help.lineW;
import static Main.Help.range;
import static org.junit.jupiter.api.Assertions.*;

class CutTest {

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

    @org.junit.jupiter.api.Test
    void WriteInFileTest() {

    }

    @org.junit.jupiter.api.Test
    void rangeTest() {
        int[] m = new int[]{3 , 0};
        assertEquals( m[1], range("-3")[1]);
        assertEquals( m[0], range("-3")[0]);
        int[] k = new int[]{1 , 3};
        assertEquals( k[1], range("1-3")[1]);
        assertEquals( k[0], range("1-3")[0]);
        int[] d = new int[]{0 , 4};
        assertEquals( d[1], range("4-")[1]);
        assertEquals( d[0], range("4-")[0]);
    }

    @org.junit.jupiter.api.Test
    void FixStrTest() {

    }


}