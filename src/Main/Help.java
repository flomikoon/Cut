package main;

import java.io.File;
import java.io.FileWriter;

public class Help {

    public static String fixStr(boolean c, boolean w, String s, Integer k, Integer n) {
        if (c) {
            s = lineC(s, k, n);
        }
        if (w) {
            s = lineW(s, k, n);
        }
        return s;
    }

    public static void writeInFile(File file, String strout) {
        try {
            FileWriter write = new FileWriter(file, true);
            write.write(strout);
            write.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    static void writeStrInFile(boolean o, File file, String strout) {
        if (!o) {
            writeInFile(file, strout);
        } else {
            System.out.print(strout);
        }
    }


    public static void writeClear(File file) {
        try {
            FileWriter write = new FileWriter(file);
            write.write("");
            write.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }


    public static String lineC(String str, Integer k, Integer n) {
        int k1 = 0;
        int n1 = 0;
        if (k != null && n == null) {
            k1 = 0;
            n1 = Integer.parseInt(Integer.toString(k));
        } else if (k == null && n != null) {
            k1 = Integer.parseInt(Integer.toString(n));
            n1 = str.length();
        } else if (k != null && n != null) {
            k1 = Integer.parseInt(Integer.toString(k));
            n1 = Integer.parseInt(Integer.toString(n));
        }

        if (n1 > str.length()) {
            n1 = str.length();
        }
        if (k1 > str.length()) {
            k1 = str.length();
        }

        str = str.substring(k1, n1);
        return str;
    }

    public static String lineW(String str, Integer k, Integer n) {
        int k1 = 0;
        int n1 = 0;
        if (k != null && n == null) {
            k1 = 0;
            n1 = Integer.parseInt(Integer.toString(k));
        } else if (k == null && n != null) {
            k1 = Integer.parseInt(Integer.toString(n));
            n1 = str.length();
        } else if (k != null && n != null) {
            k1 = Integer.parseInt(Integer.toString(k));
            n1 = Integer.parseInt(Integer.toString(n));
        }

        String[] list = str.split(" ");
        StringBuilder strBuilder = new StringBuilder();
        for (int i = k1; i < n1 && i < list.length; i++) {
            strBuilder.append(list[i]);
            strBuilder.append(" ");
        }
        str = strBuilder.toString().trim();

        return str;
    }
}
