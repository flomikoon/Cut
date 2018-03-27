package Main;

import java.io.*;
import java.util.ArrayList;

public class Cut {

    public static void main(String[] args) {
        new Cut().start(args);
    }

    private void start(String[] args){
        ArrayList<String> list = readOutFile(args[1]);
        writeInFile(args[0] , list);
    }



    private ArrayList<String> readOutFile(String str){
        InputStream in = null;
        try {
            in = new FileInputStream(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<>();
        try {
            String s;
            assert in != null;
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            while ((s = read.readLine()) != null) {
                list.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }



    private void writeInFile(String str, ArrayList<String> texts) {
        try {
            File file = new File(str);
            FileWriter write = new FileWriter(file);
            for (String text : texts) {
                write.write(text);
                //write.write("\n");
            }
            write.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }



    private ArrayList<String> lineC(ArrayList<String> texts , int k , int n){

        ArrayList<String> textout = new ArrayList<>();

        if (k != 0 && n == 0) {
            for (String text : texts) {
                textout.add(text.substring(0 , k));
            }
        } else if (k == 0 && n != 0){
            for (String text : texts) {
                textout.add(text.substring(n));
            }
        } else {
            for (String text : texts) {
                textout.add(text.substring(k , n));
            }
        }
        return textout;
    }

    private ArrayList<String> lineW(ArrayList<String> texts , int k , int n){

        ArrayList<String> textout = new ArrayList<>();


        if (k != 0 && n == 0) {
            for (String text : texts) {
                StringBuilder str;
                str = new StringBuilder();
                for (int j = 0; (j < text.length() && j < k); j++) {
                    str.append(text.charAt(j));
                }
                textout.add(str.toString());
            }
        } else if (k == 0 && n != 0){
            for (String text : texts) {
                StringBuilder str;
                str = new StringBuilder();
                for (int j = n; (j < text.length()); j++) {
                    str.append(text.charAt(j));
                }
                textout.add(str.toString());
            }
        } else {
            for (String text : texts) {
                StringBuilder str;
                str = new StringBuilder();
                for (int j = k; (j < text.length() && j < n); j++) {
                    str.append(text.charAt(j));
                }
                textout.add(str.toString());
            }
        }
        return textout;
    }

}