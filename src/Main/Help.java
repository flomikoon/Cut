package Main;

import java.io.File;
import java.io.FileWriter;

public class Help {

    public static String FixStr(String str, boolean c, boolean w, String s) {
        int k = range(str)[0];
        int n = range(str)[1];

        if (c) {
            s = lineC(s, k, n);
        }
        if (w) {
            s = lineW(s, k, n);
        }
        return  s;
    }

    public static int[] range(String str){
        int k = 0;
        int n = 0;
        int count = 0 ;
        if (str.substring(0, 1).equals("-")) {
            k = Integer.parseInt(str.substring(1));
        } else if (str.substring(str.length() - 1, str.length()).equals("-")) {
            n = Integer.parseInt(str.substring(0, str.length() - 1));
        } else {
            String line;
            String line1;
            int g = 0;

            for (int i = 0 ; i < str.length() ; i++){
                if (str.charAt(i) == '-'){
                    count ++;
                    g = i;
                    break;
                }
            }

            if(count != 0) {
                line = str.substring(0, g);
                line1 = str.substring(g + 1);
                k = Integer.parseInt(line);
                n = Integer.parseInt(line1);
            }
        }

        return new int[]{k , n};
    }


    public static void writeInFile(File file, String strout) {
        try {
            FileWriter write = new FileWriter(file);
            write.append(strout);
            write.append("\n");
            write.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }


    public static String lineC(String str, int k, int n) {
        if (k != 0 && n == 0) {
            if (str.length() < k){
                k = str.length();
            }
            str = str.substring(0, k);
        } else if (k == 0 && n != 0) {
            str = str.substring(str.length() - n);
        } else {
            str = str.substring(k, n);
        }
        return str;
    }

    public static String lineW(String str, int k, int n) {
        if (k != 0 && n == 0) {
            String[] list = str.split(" ");
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < k && i < list.length ; i++){
                strBuilder.append(list[i]);
                strBuilder.append(" ");
            }
            str = strBuilder.toString().trim();
        } else if (k == 0 && n != 0) {
            String[] list = str.split(" ");
            StringBuilder strBuilder = new StringBuilder();
            for (int i = list.length - n; i < list.length && i > 0; i++){
                strBuilder.append(list[i]);
                strBuilder.append(" ");
            }
            if ("".equals(strBuilder.toString())){
                for (String aList : list) {
                    strBuilder.append(aList);
                    strBuilder.append(" ");
                }
            }
            str = strBuilder.toString().trim();
        } else {
            String[] list = str.split(" ");
            StringBuilder strBuilder = new StringBuilder();
            for (int i = k; i < n && i < list.length ; i++){
                strBuilder.append(list[i]);
                strBuilder.append(" ");
            }
            str = strBuilder.toString().trim();
        }

        return str;
    }
}
