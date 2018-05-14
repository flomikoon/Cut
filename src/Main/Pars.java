package main;

public class Pars {

    private boolean c = false;
    private boolean w = false;
    private String str = null;
    private boolean input = false;
    private String outfile = "";
    private String inputstr = "";
    private Integer k = null;
    private Integer n = null;

    public Pars(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("-o")) {
                outfile = args[i + 1];
            }

            if (!args[i].equals("-c") && !args[i].equals("-w") && !args[i].equals("-o") && !args[i - 1].equals("-o")) {
                for (int j = 0; j < args[i].length(); j++) {
                    if (args[i].charAt(j) == '-') {
                        str = args[i];
                    }
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

        int count = 0;
        if (str.substring(0, 1).equals("-")) {
            k = Integer.parseInt(str.substring(1));
        } else if (str.substring(str.length() - 1, str.length()).equals("-")) {
            n = Integer.parseInt(str.substring(0, str.length() - 1));
        } else {
            String line;
            String line1;
            int g = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '-') {
                    count++;
                    g = i;
                    break;
                }
            }

            if (count != 0) {
                line = str.substring(0, g);
                line1 = str.substring(g + 1);
                k = Integer.parseInt(line);
                n = Integer.parseInt(line1);
            }
        }
    }

    public boolean getW() {
        return w;
    }

    public boolean getC() {
        return c;
    }

    public String getRange() {
        return str;
    }

    public boolean getO() {
        return input;
    }

    public String getOutPutFileName() {
        return outfile;
    }

    public String getInPutFileName() {
        return inputstr;
    }

    public Integer getRangeK() {
        return k;
    }

    public Integer getRangeN() {
        return n;
    }
}