import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        while (N-- > 0) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("push")) {
                queue.addLast(Integer.parseInt(command[1]));
            } else if (command[0].equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
            } else if (command[0].equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command[0].equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command[0].equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
            } else if (command[0].equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
