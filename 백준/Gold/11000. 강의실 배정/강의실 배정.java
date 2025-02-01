import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i][0]) {
                pq.poll();
            }
            pq.add(lectures[i][1]);
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
