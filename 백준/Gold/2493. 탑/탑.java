import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] heights = new int[N];
        int[] results = new int[N];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            
            while (!stack.isEmpty() && stack.peek()[1] < heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                results[i] = stack.peek()[0] + 1;
            } else {
                results[i] = 0;
            }

            stack.push(new int[]{i, heights[i]});
        }

        for (int i = 0; i < N; i++) {
            sb.append(results[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
