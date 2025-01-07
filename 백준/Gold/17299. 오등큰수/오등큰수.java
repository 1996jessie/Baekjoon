import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] freq = new int[1000001];
        int[] result = new int[n];
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            freq[arr[i]]++;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && freq[arr[stack.peek()]] < freq[arr[i]]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
