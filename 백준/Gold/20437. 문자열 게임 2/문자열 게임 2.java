import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;
            int[] count = new int[26];
            List<List<Integer>> pos = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                pos.add(new ArrayList<>());
            }
            for (int i = 0; i < W.length(); i++) {
                pos.get(W.charAt(i) - 'a').add(i);
            }
            for (int i = 0; i < 26; i++) {
                List<Integer> p = pos.get(i);
                if (p.size() < K) {
                    continue;
                }
                for (int j = 0; j <= p.size() - K; j++) {
                    int len = p.get(j + K - 1) - p.get(j) + 1;
                    if (len < minLen) {
                        minLen = len;
                    }
                    if (W.charAt(p.get(j)) == W.charAt(p.get(j + K - 1))) {
                        if (len > maxLen) {
                            maxLen = len;
                        }
                    }
                }
            }
            if (minLen == Integer.MAX_VALUE || maxLen == -1) {
                bw.write("-1\n");
            } else {
                bw.write(minLen + " " + maxLen + "\n");
            }
        }
        bw.flush();
    }
}
