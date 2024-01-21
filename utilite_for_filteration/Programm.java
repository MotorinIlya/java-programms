
import java.util.ArrayList;
import java.io.File;

public class Programm {

    static int option_o = 0;
    static int option_p = 0;
    static int option_a = 0;
    static int option_f = 0;
    static int option_s = 0;

    public static String path = ".\\";
    public static String integerName = "integer.txt";
    public static String floatName = "float.txt";
    public static String stringName = "string.txt";
    static ArrayList<String> files = new ArrayList<String>();
    
    public static void main(String [] args){
        for (String s : args){
            if (s.equals("-o")){
                option_o += 1;
            }
            else if (s.equals("-p")){
                option_p += 1;
            }
            else if (s.equals("-a")){
                option_a += 1;
            }
            else if (s.equals("-f")){
                option_f += 1;
            }
            else if (s.equals("-s")){
                option_s += 1;
            }
            else if (option_o == 1){
                File file = new File(s);
                if (file.isDirectory()){
                    path = s;
                    option_o += 1;
                }
                else {
                    System.out.println("After the -o option, the path is entered incorrectly");
                    return;
                }
            }
            else if (option_p == 1){
                integerName = s + integerName;
                floatName = s + floatName;
                stringName = s + stringName;
                option_p += 1;
            }
            else if (FileIdentify.isFile(s)){
                files.add(s);
            }
        }

        if (option_o > 2 || option_p > 2 || option_a > 1 || option_f > 1 || option_s > 1){
            System.out.println("There are too many options");
            return;
        }

        if (option_a == 0){
            File fileI = new File (path + "\\" + integerName);
            fileI.delete();
            File fileF = new File (path + "\\" + floatName);
            fileF.delete();
            File fileS = new File (path + "\\" + stringName);
            fileS.delete(); 
        }

        StatisticField statistic = new StatisticField();
        for (String s : files){
            Parser.parseFile(s, statistic);
        }

        if (option_f == 1) {
            System.out.println("------------------------------------------");
            System.out.println("count integer elements: " + statistic.giveCountInteger());
            System.out.println("count float elements: " + statistic.giveCountFloat());
            System.out.println("max element: " + statistic.giveMaxNumber());
            System.out.println("min element: " + statistic.giveMinNumber());
            System.out.println("summ elements: " + statistic.giveSumm());
            double midlaneElement = statistic.giveSumm() / (statistic.giveCountFloat() + statistic.giveCountInteger());
            System.out.println("midlane element: " + midlaneElement);
            System.out.println("count string elements: " + statistic.giveCountString());
            System.out.println("min length: " + statistic.giveMinLength());
            System.out.println("max length: " + statistic.giveMaxLength());
        }
        else if (option_s == 1) {
            System.out.println("------------------------------------------");
            System.out.println("count integer elements: " + statistic.giveCountInteger());
            System.out.println("count float elements: " + statistic.giveCountFloat());
            System.out.println("count string elements: " + statistic.giveCountString());
        }
    }
}
