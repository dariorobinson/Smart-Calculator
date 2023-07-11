import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        BigInteger num = new BigInteger(input);

        BigInteger fact = BigInteger.ONE;
        BigInteger i = BigInteger.ONE;

        while(fact.compareTo(num) < 0) {
            fact = fact.multiply(i);
            i = i.add(BigInteger.ONE);
        }

        System.out.println(i.subtract(BigInteger.ONE));

    }
}