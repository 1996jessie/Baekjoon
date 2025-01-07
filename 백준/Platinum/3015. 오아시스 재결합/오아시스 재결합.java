import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        long pairCount = 0;
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;
            
            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                pairCount += stack.peek()[1];
                
                if (stack.peek()[0] == height) {
                    count += stack.pop()[1];
                } else {
                    stack.pop();
                }
            }
            
            if (!stack.isEmpty()) {
                pairCount++;
            }
            
            stack.push(new int[] {height, count});
        }
        
        bw.write(pairCount + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
