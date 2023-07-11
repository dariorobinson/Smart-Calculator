import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(isBalanced(input));
    }

    public static boolean isBalanced(String str) {
        if (str.length() == 0) return false;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
                deque.push(str.charAt(i));
            }
            if (deque.size() == 0) return false;
            if (str.charAt(i) == '}') {
                if(deque.peek() == '{') {
                    deque.pop();
                } else {
                    deque.push(str.charAt(i));
                }
            } else if(str.charAt(i) == ')') {
                if (deque.peek() == '(') {
                    deque.pop();
                } else {
                    deque.push(str.charAt(i));
                }
            } else if (str.charAt(i) == ']') {
                if (deque.peek() == '[') {
                    deque.pop();
                } else {
                    deque.push(str.charAt(i));
                }
            }
        }
        if (deque.size() == 0) {
            return true;
        }
        return false;
    }
}
