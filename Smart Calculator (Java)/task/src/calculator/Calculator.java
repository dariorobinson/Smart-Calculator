package calculator;
import java.math.BigInteger;
import java.util.*;

public class Calculator {
    private final Scanner scanner = new Scanner(System.in);

    private final Map<String, String> map = new HashMap<>();

    public void printFromMap(String str) {
            System.out.println(map.get(str));
    }

    public int Prec(String input)
    {
        return switch (input) {
            case "(", ")" -> 1;
            case "+", "-" -> 2;
            case "*", "/" -> 3;
            case "^" -> 4;
            default -> -1;
        };
    }

    public String reverseNotation(String[] exp) {

        StringBuilder result = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (String c : exp) {
            if (c.matches("[0-9]+")) {
                result.append(c).append(" ");
            } else if (c.matches("[a-zA-Z]+")) {
                if (map.containsKey(c)) {
                    result.append(map.get(c)).append(" ");
                } else {
                    System.out.println("Invalid variable");
                }
            } else if (c.equals("(")) {
                stack.push(c);
            } else if (c.equals(")")) {
                while (!stack.isEmpty()
                        && !stack.peek().equals("(")) {
                    result.append(stack.peek()).append(" ");
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && Prec(c) <= Prec(stack.peek())) {

                    result.append(stack.peek()).append(" ");
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("("))
                return "Invalid Expression";
            result.append(stack.peek()).append(" ");
            stack.pop();
        }
        return result.toString();
    }

    public void calculate(String[] tokens) {
        Stack<String> stack = new Stack<>();
        BigInteger x;
        BigInteger y;
        String result;
        String choice;
        BigInteger value;
        String p = "";
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].matches("[\\*\\+/-]")) {
                stack.push(tokens[i]);
                continue;
            }
            else {
                choice = tokens[i];
            }
            switch (choice) {
                case "+":
                    x = new BigInteger(stack.pop());
                    y = new BigInteger(stack.pop());
                    value = x.add(y);
                    result = p + value;
                    stack.push(result);
                    break;
                case "-":
                    x = new BigInteger(stack.pop());
                    y = new BigInteger(stack.pop());
                    value = y.subtract(x);
                    result = p + value;
                    stack.push(result);
                    break;
                case "*":
                    x = new BigInteger(stack.pop());
                    y = new BigInteger(stack.pop());
                    value = x.multiply(y);
                    result = p + value;
                    stack.push(result);
                    break;
                case "/":
                    x = new BigInteger(stack.pop());
                    y = new BigInteger(stack.pop());
                    value = y.divide(x);
                    result = p + value;
                    stack.push(result);
                    break;
                case "^":
                    x = new BigInteger(stack.pop());
                    y = new BigInteger(stack.pop());
                    value = BigInteger.valueOf((long) Math.pow(x.doubleValue(), y.doubleValue()));
                    result = p + value;
                    stack.push(result);
                    break;
                default:
            }
        }

        try {
            System.out.println(stack.pop());
        } catch(Exception e) {
            System.out.println("Invalid expression");
        }

    }

    public void addToMap(String str, Map<String, String> map) {

        str = str.replaceAll("=", " ");
        str = str.replaceAll("\\s+", " ");

        String[] arr = str.split(" ");
        if(arr.length == 2) {
            if (!arr[0].matches("[a-zA-Z]+")) {
                System.out.println("Invalid identifier");
            } else if (arr[0].matches("[a-zA-Z]+") && arr[1].matches("-?[0-9]+")){
                map.put(arr[0], arr[1]);
            } else if (!arr[1].matches("[a-zA-Z]+") || !map.containsKey(arr[1])) {
                System.out.println("Invalid assignment");
            } else if (arr[1].matches("[a-zA-Z]+") && map.containsKey(arr[1])) {
                map.put(arr[0], map.get(arr[1]));
            }
        } else {
            System.out.println("Invalid assignment");
        }

    }
    public void start() {

        while(true) {
            String numInput = scanner.nextLine();

            if (numInput.equals("")) {
                continue;
            } else if (numInput.equals("/exit")) {
                System.out.println("Bye!");
                break;
            } else if (numInput.equals("/help")) {
                System.out.println("The program calculates the sum of numbers");
                continue;
            } else if(numInput.substring(0,1).equals("/") && numInput.substring(1).matches("[a-zA-Z]+")) {
                System.out.println("Unknown command");
                continue;
            }

            numInput = numInput.replaceAll("=", " = ");
            numInput = numInput.replaceAll("\\(", "( ");
            numInput = numInput.replaceAll("\\)", " )");
            numInput = numInput.replaceAll("--", "+");
            numInput = numInput.replaceAll("\\++", " + ");
            numInput = numInput.replaceAll("\\+ -+", "- ");
            numInput = numInput.replaceAll("\\*", " * ");
            numInput = numInput.replaceAll("/", " / ");
            numInput = numInput.replaceAll("\\s+", " ");
            numInput = numInput.trim();
            String[] nums = numInput.split(" ");

            boolean valid = isValidExpression(numInput);


            for(int i = 0; i < nums.length; i++) {
                if (nums[i].matches("[+]+\\d+")) {
                    nums[i] = nums[i].substring(1);
                }
            }

            if(nums.length <= 1) {
                if(map.containsKey(numInput)) {
                    printFromMap(numInput);
                } else {
                    System.out.println("Unknown variable");
                }
                continue;
            }

            if(nums.length > 1 && nums[1].equals("=")) {
                addToMap(numInput, map);
                continue;
            }
            if(valid) {

                 if (nums.length == 1) {
                    System.out.println(nums[0]);
                } else {
                     String polishNotation = reverseNotation(nums);
                     calculate(polishNotation.split(" "));
                }
            } else {
                System.out.println("Invalid expression");
            }

        }
    }

    public boolean isValidExpression(String str) {
        String line = str.replaceAll(" {2,}", " ");
        line = line.replaceAll("--", "+");

        String[] arr = line.split(" ");

        int countOne = 0;
        int countTwo = 0;

        int multiplicationCount = 0;
        int divisionCount = 0;
        for(String element: arr) {
            if (multiplicationCount > 1) {
                return false;
            }
            if(divisionCount > 1) {
                return false;
            }

            if(element.equals("(")) {
                countOne++;
            } else if(element.equals(")")) {
                countTwo++;
            } else if(element.matches("\\*{2,}")) {
                return false;
            } else if (element.matches("/{2,}")) {
                return false;
            } else if (element.equals("*")) {
                multiplicationCount++;
            } else if(element.equals("/")) {
                divisionCount++;
            }

            if(!element.equals("*")) {
                multiplicationCount = 0;
            } else if(!element.equals("/")) {
                divisionCount = 0;
            }
        }

        if(countOne != countTwo) {
            return false;
        }
        return true;
    }
}
