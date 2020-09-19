import java.io.*;
import java.util.Arrays;

public class Calculator {
    public static String[] arab = new String[]{"10","1","2","3","4","5","6","7","8","9"};
    static boolean isRoman = false;
    public static void main(String[] args) throws IOException, OperatorException, SizeException, NumberTypeException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        String[] splitedString = splitString(str);
        checkUtils.checkNumberType(splitedString[0],splitedString[2]);
        if (!Arrays.asList(arab).contains(splitedString[0]) && !Arrays.asList(arab).contains(splitedString[2]) ) {
            NumberConverter.convertRomeToArab(splitedString);
            isRoman = true;
        }
        checkUtils.checkOperator(splitedString[1]);
        checkUtils.checkNumberSize(splitedString[0]);
        checkUtils.checkNumberSize(splitedString[2]);
        calculate(splitedString);


    }

    private static String[] splitString(String str) {
        String[] subStr;
        String delimeter = "\\s";
        subStr = str.split(delimeter);
        return subStr;
    }

    private static void calculate(String[] str) {
        int answer = 0;
        if (str[1].equals("-"))
            answer = Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
        else if (str[1].equals("+"))
            answer = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
        else if (str[1].equals("*"))
            answer = Integer.parseInt(str[0]) * Integer.parseInt(str[2]);
        else if (str[1].equals("/"))
            answer = Integer.parseInt(str[0]) / Integer.parseInt(str[2]);

        if (isRoman)
            System.out.println(NumberConverter.arabicToRoman(answer));
        else
            System.out.println(answer);
    }

}
