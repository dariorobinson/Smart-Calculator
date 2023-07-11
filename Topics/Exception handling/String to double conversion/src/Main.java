import java.util.Scanner;

class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        double d;
        try {
            d = Double.parseDouble(input);
        } catch(Exception e) {
            return 0;
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(convertStringToDouble(input));
    }
}