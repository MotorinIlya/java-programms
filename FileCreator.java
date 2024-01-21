import java.io.File;

public class FileCreator {
    public static File createFile(String nameFile, String pathFile){
        File file = new File(pathFile + "\\" + nameFile);
        return file;
    }
}
