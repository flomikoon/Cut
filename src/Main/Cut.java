package Main;

import java.io.*;
import java.util.Scanner;

public class Cut {

    public static void main(String[] args) {
        new Cut().start(args);
    }

    private void start(String[] args) {

        String outfilename = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                outfilename = args[i + 1];
            }
        }

        File out = new File(outfilename);

        String str = null;

        for (String arg : args){
            for (int j = 0; j < arg.length() ; j++){
                if (arg.charAt(j) == '-'){
                    str = arg;
                }
            }
        }

        boolean input = false;
        String inputstr = "";

        for (int i = 1; i < args.length; i++) {
            if (!args[i].equals("-c") && !args[i].equals("-w") && !args[i].equals("-o") && !args[i - 1].equals("-o") && !args[i].equals(str)) {
                input = true;
                inputstr = args[i];
            }
        }

        String s;

        if (input) {
            try {
                InputStream in = new FileInputStream(inputstr);
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                while ((s = read.readLine())!= null) {
                    FixStr(str, args, s, outfilename, out);
                }
            } catch (IOException e) {
                System.out.print("Ошибка. Файл не найден");
            }
        } else {
            Scanner in = new Scanner(System.in);
            while ((s = in.nextLine()).length() > 0) {
                FixStr(str, args, s, outfilename, out);
            }
        }



    }

    private void FixStr(String str , String[] args , String s , String outfilename , File out){
        int k = range(str)[0];
        int n = range(str)[1];

        for (String arg : args) {
            if (arg.equals("-c")) {
                s = lineC(s, k, n);
            }
            if (arg.equals("-w")) {
                s = lineW(s, k, n);
            }
        }

        if (!outfilename.equals("")) {
            writeInFile(out, s);
        } else {
            System.out.print(s);
            System.out.print("\n");
        }
    }

    private int[] range(String str){
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


    private void writeInFile(File file, String strout) {
        try {
            FileWriter write = new FileWriter(file , true);
            write.append(strout);
            write.append("\n");
            write.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }


    private String lineC(String str, int k, int n) {
        if (k != 0 && n == 0) {
            str = str.substring(0, k);
        } else if (k == 0 && n != 0) {
            str = str.substring(str.length() - n);
        } else {
            str = str.substring(k, n);
        }
        return str;
    }

    private String lineW(String str, int k, int n) {
        if (k != 0 && n == 0) {
            String[] list = str.split(" ");
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < k && i < list.length ; i++){
                strBuilder.append(list[i]);
                strBuilder.append(" ");
            }
            str = strBuilder.toString();
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
            str = strBuilder.toString();
        } else {
            String[] list = str.split(" ");
            StringBuilder strBuilder = new StringBuilder();
            for (int i = k; i < n && i < list.length ; i++){
                strBuilder.append(list[i]);
                strBuilder.append(" ");
            }
            str = strBuilder.toString();
        }

        return str;
    }

}