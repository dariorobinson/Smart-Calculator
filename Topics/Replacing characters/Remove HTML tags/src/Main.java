import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringWithHtmlTags = scanner.nextLine();
        String regex = "<.+?>";
        String result = stringWithHtmlTags.replaceAll(regex, "");
        System.out.println(result);
        // write your code here
    }
}
