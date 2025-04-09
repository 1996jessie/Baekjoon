import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int aCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'P') {
                stack.push('P');
            } else {
                aCount++;
                if (stack.size() < 2 || i + 1 >= s.length() || s.charAt(i + 1) != 'P') {
                    System.out.println("NP");
                    return;
                }
                stack.pop();
                stack.pop();
                i++;
                stack.push('P');
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
