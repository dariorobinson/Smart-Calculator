import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine().toLowerCase();
        String line = scanner.nextLine().toLowerCase();

        String[] arr = line.split(" ");

        boolean isMatch = false;
        Pattern pattern = Pattern.compile(".+" + part + ".+");

        for(String element: arr) {
            Matcher match = pattern.matcher(element);
            if (match.matches()) {
                isMatch = true;
            }
        }

        if(isMatch) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}