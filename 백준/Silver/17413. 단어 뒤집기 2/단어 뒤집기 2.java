import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean inTag = false;

        for (char c : S.toCharArray()) {
            if (c == '<') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                inTag = true;
                result.append(c);
            } else if (c == '>') {
                inTag = false;
                result.append(c);
            } else if (inTag) {
                result.append(c);
            } else {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }
                    result.append(c);
                } else {
                    stack.push(c);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        System.out.println(result);
    }
}
