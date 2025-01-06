import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while (!(line = br.readLine()).equals("0")) {
            String[] input = line.split(" ");
            int n = Integer.parseInt(input[0]);
            long[] heights = new long[n];
            
            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(input[i + 1]);
            }
            
            sb.append(getMaxArea(heights)).append("\n");
        }
        
        System.out.print(sb);
    }

    static long getMaxArea(long[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                long height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
