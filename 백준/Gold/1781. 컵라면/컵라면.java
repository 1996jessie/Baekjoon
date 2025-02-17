import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<int[]> problems = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            problems.add(new int[]{deadline, ramen});
        }

        problems.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        for (int[] p : problems) {
            pq.offer(p[1]);
            if (pq.size() > p[0]) {
                pq.poll();
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
