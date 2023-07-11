import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String arr = scan.nextLine();
        String compare = scan.nextLine();

        String[] array = arr.split(" ");

        List<String> list = new ArrayList<>();
        List<String> returnList = new ArrayList<>();

        list.addAll(List.of(array));

        int close = Integer.valueOf(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            if (Math.abs(Integer.valueOf(list.get(i)) - Integer.valueOf(compare)) < Math.abs(Integer.valueOf(close) - Integer.valueOf(compare))) {
                close = Integer.valueOf(list.get(i));
            } else if (Math.abs(Integer.valueOf(list.get(i)) - Integer.valueOf(compare)) == Math.abs(Integer.valueOf(close) - Integer.valueOf(compare))) {
                returnList.add(list.get(i));
            }
        }
        returnList.add(String.valueOf(close));

        List<String> sortedReturn = returnList.stream().sorted().collect(Collectors.toList());
        for (String str: sortedReturn) {
            System.out.print(str + " ");
        }
    }
}
