import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (queue.size() > 1) {
            sb.append(queue.poll()).append(" ");
            queue.add(queue.poll());
        }

        sb.append(queue.poll());
        System.out.println(sb);
    }
}
