package Main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static Main.Help.*;

public class Cut {

    public static void main(String[] args) {
        new Cut().start(args);
    }

    private void start(String[] args) {
        Pars h = new Pars(args);
        String res;
        String d;

        File dile = new File(h.getOutPutFileName());
        writeClear(dile);

        if (h.getW() == h.getC()) {
            System.err.print("Должен быть задан только один из флагов -c или -w");
            System.exit(0);
        }

        Scanner in = new Scanner(System.in);

        if (h.getO()) {
            Path path = Paths.get(h.getInPutFileName());
            try {
                in = new Scanner(path);
            } catch (IOException e) {
                System.err.print("Файл не найлен");
            }
        }

        while (in.hasNext()) {
            d = in.nextLine();
            res = fixStr(h.getC(), h.getW(),
                    d, h.getRangeK(), h.getRangeN());
            res += "\n";
            writeStrInFile(h.getOutPutFileName().equals(""), dile, res);
        }
        in.close();


    }

}