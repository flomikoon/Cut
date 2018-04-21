package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static main.Help.writeClear;
import static main.Help.writeStrInFile;

public class Cut {

    public static void main(String[] args) {
        new Cut().start(args);
    }

    private void start(String[] args) {
        new Pars(args);
        String res;
        String s;

        File dile = new File(new Pars(args).getOutPutFileName());
        writeClear(dile);

        if (new Pars(args).getW() == new Pars(args).getC()) {
            System.err.print("Должен быть задан только один из флагов -c или -w");
            System.exit(0);
        }

        Scanner in;
        if (new Pars(args).getO()) {
            Path path = Paths.get(new Pars(args).getInPutFileName());
            try {
                in = new Scanner(path);
                while (in.hasNext()) {
                    s = in.nextLine();
                    res = Help.fixStr(new Pars(args).getC(), new Pars(args).getW(),
                            s, new Pars(args).getRangeK(), new Pars(args).getRangeN());
                    res += "\n";
                    writeStrInFile(new Pars(args).getOutPutFileName().equals(""), dile, res);
                }
                in.close();
            } catch (IOException e) {
                System.err.print("Файл не найден");
            }
        } else {
            in = new Scanner(System.in);
            while ((s = in.nextLine()).length() > 0) {
                res = Help.fixStr(new Pars(args).getC(), new Pars(args).getW(),
                        s, new Pars(args).getRangeK(), new Pars(args).getRangeN());
                res += "\n";
                writeStrInFile(new Pars(args).getOutPutFileName().equals(""), dile, res);
            }
        }
    }

}