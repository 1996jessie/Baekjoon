import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] students = new int[N];
        
        for (int i = 0; i < N; i++) {
            students[i] = scanner.nextInt();
        }
        
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        
        for (int student : students) {
            stack.push(student);
            
            while (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                current++;
            }
        }
        
        if (current == N + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
        
        scanner.close();
    }
}
