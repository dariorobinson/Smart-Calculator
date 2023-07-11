import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();
        String[] arr = url.split("[&?]");
        for (int i = 1; i < arr.length; i++) {
            String lastChar = arr[i].substring(arr[i].length() - 1);
            if (!"=".equals(lastChar)) {
                System.out.println(arr[i].replaceAll("=", " : "));
            } else {
                String[] split = arr[i].split("=");
                System.out.println(split[0] + " : not found");
            }

        }
        for (String element: arr) {
            String lastChar = element.substring(element.length() - 1);
            if (element.contains("pass=") && !"=".equals(lastChar)) {
                String password = element;
                String[] passwords = password.split("=");
                System.out.println("password : " + passwords[1]);
            }
        }
    }
}