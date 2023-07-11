import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        String[] lines = line.split(" ");

        Pattern pattern = Pattern.compile("\\w[^~,]+");

        boolean isLength = false;
        for(String word: lines) {
            Matcher match = pattern.matcher(word);
            if (word.length() == size && match.matches()) {
                isLength = true;
            }
        }

        if(isLength) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}