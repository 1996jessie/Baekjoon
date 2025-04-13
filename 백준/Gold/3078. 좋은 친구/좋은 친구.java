import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nameLengthCount = new int[21];
        Queue<Integer>[] queues = new Queue[21];
        for (int i = 2; i <= 20; i++) {
            queues[i] = new LinkedList<>();
        }

        long result = 0;

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            int len = name.length();

            while (!queues[len].isEmpty() && queues[len].peek() < i - K) {
                queues[len].poll();
            }

            result += queues[len].size();
            queues[len].add(i);
        }

        System.out.println(result);
    }
}
