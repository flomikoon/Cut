package Main;

import java.io.*;
import java.util.Scanner;

import static Main.Help.writeInFile;

public class Cut {

    public static void main(String[] args) {
        new Cut().start(args);
    }

    private void start(String[] args) {

        String outfile = "";
        String str = null;
        StringBuilder res = new StringBuilder("");
        boolean input = false;
        String inputstr = "";
        String s;
        boolean c = false;
        boolean w = false;


        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("-o")) {
                outfile = args[i + 1];
            }

            for (int j = 0; j < args[i].length(); j++) {
                if (args[i].charAt(j) == '-') {
                    str = args[i];
                }
            }

            if (args[i].equals("-c")) {
                c = true;
            }

            if (args[i].equals("-w")) {
                w = true;
            }

            if (!args[i].equals("-c") && !args[i].equals("-w") && !args[i].equals("-o") && !args[i - 1].equals("-o") && !args[i].equals(str)) {
                input = true;
                inputstr = args[i];
            }
        }

        if (c != w) {
            if (input) {
                try {
                    InputStream in = new FileInputStream(inputstr);
                    BufferedReader read = new BufferedReader(new InputStreamReader(in));
                    while ((s = read.readLine()) != null) {
                        res.append(Help.FixStr(str, c, w, s));
                        res.append("\n");
                    }
                } catch (IOException e) {
                    System.err.print("Ошибка. Файл не найден");
                }
            } else {
                Scanner in = new Scanner(System.in);
                while ((s = in.nextLine()).length() > 0) {
                    res.append(Help.FixStr(str, c, w, s));
                    res.append("\n");
                }
            }
            if (!outfile.equals("")) {
                assert false;
                writeInFile(new File(outfile), res.toString());
            } else {
                assert false;
                System.out.print(res.toString());
                System.out.print("\n");
            }
        } else {
            System.err.print("Должен быть задан только один из флагов -c или -w");
        }

    }

}