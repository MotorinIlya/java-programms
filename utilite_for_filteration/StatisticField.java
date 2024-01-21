
public class StatisticField {
    private int countIntegerElements;
    private int countFloatElements;
    private int countStringElements;
    private double maxElement;
    private double minElement;
    private double summ;
    private int minLength;
    private int maxLength;

    public StatisticField (){
        countIntegerElements = 0;
        countFloatElements = 0;
        countStringElements = 0;
        maxElement = Double.MIN_VALUE;
        minElement = Double.MAX_VALUE;
        summ = 0;
        minLength = Integer.MAX_VALUE;
        maxLength = Integer.MIN_VALUE;
    }

    public void addCountElement (String type){
        if (type.equals("int")){
            countIntegerElements++;
        }
        else if (type.equals("float")){
            countFloatElements++;
        }
        else {
            countStringElements++;
        }
    }

    public void addMaxAndMinAndSumm (String number){
        double element = Double.parseDouble(number);
        if (element > maxElement){
            maxElement = element;
        }
        else if (element < minElement){
            minElement = element;
        }
        summ += element;
    }

    public void addMaxAndMinLength (String line){
        if (line.length() > maxLength){
            maxLength = line.length();
        }
        else if (line.length() < minLength){
            minLength = line.length();
        }
    }

    public int giveCountInteger () {
        return countIntegerElements; 
    }

    public int giveCountFloat () {
        return countFloatElements;
    }

    public int giveCountString () {
        return countStringElements;
    }

    public double giveMaxNumber () {
        return maxElement;
    }

    public double giveMinNumber () {
        return minElement;
    }

    public double giveSumm () {
        return summ;
    }

    public int giveMaxLength () {
        return maxLength;
    }

    public int giveMinLength () {
        return minLength;
    }
}
