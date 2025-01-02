import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < T; i++) {
            String parentheses = scanner.nextLine();
            if (isValidParenthesisString(parentheses)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
    
    private static boolean isValidParenthesisString(String parentheses) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : parentheses.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
