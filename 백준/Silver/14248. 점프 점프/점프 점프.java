import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stones = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = Integer.parseInt(br.readLine()) - 1;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int jump = stones[curr];

            if (curr + jump < n && !visited[curr + jump]) {
                queue.add(curr + jump);
                visited[curr + jump] = true;
                count++;
            }
            if (curr - jump >= 0 && !visited[curr - jump]) {
                queue.add(curr - jump);
                visited[curr - jump] = true;
                count++;
            }
        }

        System.out.println(count);
    }
}
