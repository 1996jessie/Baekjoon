import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] priorities = new int[N];
            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
                queue.add(new int[] {i, priorities[i]});
            }

            Arrays.sort(priorities);
            int maxPriorityIndex = N - 1;
            int printOrder = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                if (current[1] == priorities[maxPriorityIndex]) {
                    printOrder++;
                    maxPriorityIndex--;
                    if (current[0] == M) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
        }
        System.out.print(sb);
    }
}
