


import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static String readString (FileReader reader) throws IOException {
        int c = 0;
        String line = "";
        while (((char)(c = reader.read()) != '\n') && (c != -1))
        {
            line += (char)c;
        }
        return line;
    }
}
