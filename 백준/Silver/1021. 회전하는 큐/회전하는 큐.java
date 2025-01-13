import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> targets = new ArrayList<>();
        while (st.hasMoreTokens()) {
            targets.add(Integer.parseInt(st.nextToken()));
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int result = 0;

        for (int target : targets) {
            int idx = deque.indexOf(target);
            int leftMove = idx;
            int rightMove = deque.size() - idx;

            if (leftMove <= rightMove) {
                for (int i = 0; i < leftMove; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                for (int i = 0; i < rightMove; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }

            deque.removeFirst();
            result += Math.min(leftMove, rightMove);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
