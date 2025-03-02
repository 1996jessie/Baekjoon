import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] counts = new int[k];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < k; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
            maxHeap.add(new int[]{counts[i], i + 1});
        }
        
        if (maxHeap.peek()[0] > (n + 1) / 2) {
            System.out.println(-1);
            return;
        }
        
        int[] result = new int[n];
        int index = 0;
        
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int count = current[0];
            int color = current[1];
            
            for (int i = 0; i < count; i++) {
                result[index] = color;
                index += 2;
                if (index >= n) {
                    index = 1;
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
