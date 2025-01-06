import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            } else {
                return Math.abs(a) - Math.abs(b);
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (!absHeap.isEmpty()) {
                    bw.write(absHeap.poll() + "\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                absHeap.offer(x);
            }
        }

        bw.flush();
        bw.close();
    }
}
