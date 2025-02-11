import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String arrayInput = br.readLine();

            if (n > 0) {
                String[] elements = arrayInput.substring(1, arrayInput.length() - 1).split(",");
                for (String elem : elements) {
                    deque.add(Integer.parseInt(elem));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else { 
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        
        System.out.print(sb);
    }
}
