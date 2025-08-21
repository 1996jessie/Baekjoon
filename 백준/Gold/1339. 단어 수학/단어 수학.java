import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Integer> weight = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int w = (int) Math.pow(10, len - i - 1);
                weight.put(c, weight.getOrDefault(c, 0) + w);
            }
        }

        List<Integer> values = new ArrayList<>(weight.values());
        Collections.sort(values, Collections.reverseOrder());

        int num = 9;
        int sum = 0;
        for (int v : values) {
            sum += v * num;
            num--;
        }

        System.out.println(sum);
    }
}
