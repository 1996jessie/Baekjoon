import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int ones = 0, zeros = 0, result = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                ones++;
            } else if (num == 0) {
                zeros++;
            } else {
                negative.add(num);
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        for (int i = 0; i + 1 < positive.size(); i += 2) {
            result += positive.get(i) * positive.get(i + 1);
        }
        if (positive.size() % 2 == 1) {
            result += positive.get(positive.size() - 1);
        }

        for (int i = 0; i + 1 < negative.size(); i += 2) {
            result += negative.get(i) * negative.get(i + 1);
        }
        if (negative.size() % 2 == 1) {
            if (zeros == 0) {
                result += negative.get(negative.size() - 1);
            }
        }

        result += ones;
        System.out.println(result);
    }
}
