import java.util.Arrays;

public class checkUtils {

    public static void checkOperator(String operator) throws OperatorException {
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/"))
            throw new OperatorException();
    }

    public static void checkNumberSize(String number) throws SizeException {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 10)
            throw new SizeException();
    }

    public static void checkNumberType(String number1, String number2) throws NumberTypeException {
        if (Arrays.asList(Calculator.arab).contains(number1) && !Arrays.asList(Calculator.arab).contains(number2))
            throw new NumberTypeException();
    }
}
