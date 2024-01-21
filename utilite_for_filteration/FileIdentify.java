public class FileIdentify {
    public static boolean isFile (String name){
        return name.matches("\\w+.txt");
    }

    public static boolean isInteger (String name){
        return name.matches("\\s*(-)?\\d+\\s*");
    }

    public static boolean isFloat (String name){
        return name.matches("\\s*(-)?\\d+.\\d+(e-|e+)?\\d+\\s*");
    }
}
