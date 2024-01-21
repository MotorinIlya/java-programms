
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Parser {
    public static void parseFile (String nameFile, StatisticField statistic){
        try { 
            FileReader reader = new FileReader(nameFile);
            String line = Reader.readString(reader);
            while (!line.equals("")){
                
                if (FileIdentify.isInteger(line)){
                    File file = FileCreator.createFile(Programm.integerName, Programm.path);
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(line + "\n");
                    writer.close();
                    statistic.addCountElement("int");
                    statistic.addMaxAndMinAndSumm(line);
                }
                else if (FileIdentify.isFloat(line)){
                    File file = FileCreator.createFile(Programm.floatName, Programm.path);
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(line + "\n");
                    writer.close();
                    statistic.addCountElement("float");
                    statistic.addMaxAndMinAndSumm(line);
                }
                else {
                    File file = FileCreator.createFile(Programm.stringName, Programm.path);
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(line + "\n");
                    writer.close();
                    statistic.addCountElement("string");
                    statistic.addMaxAndMinLength(line);
                }
                line = Reader.readString(reader);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
