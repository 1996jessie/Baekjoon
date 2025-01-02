import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String line = scanner.nextLine();
            if (line.equals(".")) {
                break;
            }
            if (isBalanced(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        scanner.close();
    }

    private static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : line.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (ch == '.') {
                break;
            }
        }
        
        return stack.isEmpty();
    }
}
