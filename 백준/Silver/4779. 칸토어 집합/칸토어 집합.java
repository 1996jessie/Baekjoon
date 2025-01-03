import java.io.*;

public class Main {
    static StringBuilder init(String ch, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(ch);
        }
        return sb;
    }

    static StringBuilder kan(StringBuilder sb) {
        return cantorSet(sb, 0, sb.length() - 1);
    }

    static StringBuilder cantorSet(StringBuilder sb, int start, int end) {
        if (start >= end) {
            return sb;
        }

        int length = end - start + 1;
        int third = length / 3;

        for (int i = start + third; i < start + 2 * third; i++) {
            sb.setCharAt(i, ' ');
        }

        cantorSet(sb, start, start + third - 1);
        cantorSet(sb, start + 2 * third, end);

        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input == null || input.isBlank()) {
                break;
            }
            int size = (int) Math.pow(3, Integer.parseInt(input));
            StringBuilder sb = init("-", size);
            if (size == 0) {
                System.out.println(sb.toString());
            } else {
                System.out.println(kan(sb).toString());
            }
        }
    }
}
