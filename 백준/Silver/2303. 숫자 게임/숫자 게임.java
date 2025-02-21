import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int winner = 0, maxDigit = -1;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cards = new int[5];
            for (int j = 0; j < 5; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
            }

            int maxMod = 0;
            for (int a = 0; a < 3; a++) {
                for (int b = a + 1; b < 4; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        maxMod = Math.max(maxMod, (cards[a] + cards[b] + cards[c]) % 10);
                    }
                }
            }

            if (maxMod >= maxDigit) {
                maxDigit = maxMod;
                winner = i;
            }
        }

        System.out.println(winner);
    }
}
