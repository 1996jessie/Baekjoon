import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String initial = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (char c : initial.toCharArray()) {
            left.addLast(c);
        }
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            if (command.equals("L")) {
                if (!left.isEmpty()) {
                    right.addFirst(left.removeLast());
                }
            } else if (command.equals("D")) {
                if (!right.isEmpty()) {
                    left.addLast(right.removeFirst());
                }
            } else if (command.equals("B")) {
                if (!left.isEmpty()) {
                    left.removeLast();
                }
            } else if (command.startsWith("P")) {
                left.addLast(command.charAt(2));
            }
        }
        for (char c : left) {
            bw.write(c);
        }
        for (char c : right) {
            bw.write(c);
        }
        bw.flush();
    }
}
