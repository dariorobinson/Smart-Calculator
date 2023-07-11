import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        String one = scan.nextLine().toLowerCase();
        String two = scan.nextLine().toLowerCase();

        Map<Character, Integer> oneMap = new HashMap<>();
        Map<Character, Integer> twoMap = new HashMap<>();

        for (int i = 0; i < one.length(); i++) {
            if (!oneMap.containsKey(one.charAt(i))) {
                oneMap.put(one.charAt(i), 1);
            } else {
                oneMap.put(one.charAt(i), oneMap.get(one.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < two.length(); i++) {
            if (!twoMap.containsKey(two.charAt(i))) {
                twoMap.put(two.charAt(i), 1);
            } else {
                twoMap.put(two.charAt(i), twoMap.get(two.charAt(i)) + 1);
            }
        }

        if (Objects.equals(oneMap, twoMap)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}