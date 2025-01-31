import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            count += stack.size();
            stack.push(height);
        }
        
        bw.write(Long.toString(count));
        bw.flush();
        br.close();
        bw.close();
    }
}
