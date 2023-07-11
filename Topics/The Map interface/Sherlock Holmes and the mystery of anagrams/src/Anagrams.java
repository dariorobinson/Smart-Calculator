import java.util.HashMap;
import java.util.Map;

public class Anagrams {


    public void isAnagram(String one, String two) {
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
            if (!twoMap.containsKey(one.charAt(i))) {
                twoMap.put(one.charAt(i), 1);
            } else {
                twoMap.put(one.charAt(i), twoMap.get(two.charAt(i)) + 1);
            }
        }

        if (twoMap == oneMap) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
