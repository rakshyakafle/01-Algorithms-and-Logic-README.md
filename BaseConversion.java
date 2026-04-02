//Rakshya Kafle
//OCCC - AdvanceJava
//Base Converison



import java.math.BigInteger;
import java.util.Scanner;

public class BaseConversion {

    public static void main(String[] args) {

        String initialValue;
        int initialBase;
        int finalBase;

        if (args.length == 3) {
            initialValue = args[0];
            initialBase = Integer.parseInt(args[1]);
            finalBase = Integer.parseInt(args[2]);
        } 
        else if (args.length != 0) {
            System.out.println("Usage: java BaseConversions <value> <initialBase> <finalBase>");
            return;
        } 
        else {
            Scanner s = new Scanner(System.in);

            System.out.println("Welcome to the Base Conversion Program!");
            System.out.print("Enter the value to convert: ");
            initialValue = s.next();

            System.out.print("Enter the initial base: ");
            initialBase = Integer.parseInt(s.next());

            System.out.print("Enter the desired base: ");
            finalBase = Integer.parseInt(s.next());
        }

        if (!isValidInteger(initialValue, initialBase)) {
            System.out.println("Error: Invalid number for the given base.");
            return;
        }

        String result = convertInteger(initialValue, initialBase, finalBase);
        System.out.println("Converted value: " + result);
    }

    public static boolean isValidInteger(String theValue, int theBase) {

        if (theBase < 2 || theBase > 36 || theValue == null || theValue.length() == 0) {
            return false;
        }

        theValue = theValue.toUpperCase();

        for (int i = 0; i < theValue.length(); i++) {
            char c = theValue.charAt(i);
            int digit;

            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } 
            else if (c >= 'A' && c <= 'Z') {
                digit = c - 'A' + 10;
            } 
            else {
                return false;
            }

            if (digit >= theBase) {
                return false;
            }
        }
        return true;
    }

    public static String convertInteger(String theValue, int initialBase, int finalBase) {

        theValue = theValue.toUpperCase();

        BigInteger value = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(initialBase);

        for (int i = 0; i < theValue.length(); i++) {
            char c = theValue.charAt(i);
            int digit;

            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } 
            else {
                digit = c - 'A' + 10;
            }

            value = value.multiply(base).add(BigInteger.valueOf(digit));
        }

        if (value.equals(BigInteger.ZERO)) {
            return "0";
        }

        String result = "";
        BigInteger finalBaseBI = BigInteger.valueOf(finalBase);

        while (value.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = value.mod(finalBaseBI);
            int r = remainder.intValue();

            char digitChar;
            if (r < 10) {
                digitChar = (char) ('0' + r);
            } 
            else {
                digitChar = (char) ('A' + r - 10);
            }

            result = digitChar + result;
            value = value.divide(finalBaseBI);
        }

        return result;
    }
}
