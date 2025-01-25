import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            result.add(queue.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
