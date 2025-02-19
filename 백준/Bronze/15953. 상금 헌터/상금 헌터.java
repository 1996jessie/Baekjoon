import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] firstPrize = {500, 300, 200, 50, 30, 10};
        int[] firstRank = {1, 2, 3, 4, 5, 6};
        int[] secondPrize = {512, 256, 128, 64, 32};
        int[] secondRank = {1, 2, 4, 8, 16};

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int sum = 0;

            if (a > 0 && a <= 21) {
                int rank = 0;
                for (int i = 0; i < 6; i++) {
                    rank += firstRank[i];
                    if (a <= rank) {
                        sum += firstPrize[i] * 10000;
                        break;
                    }
                }
            }

            if (b > 0 && b <= 31) {
                int rank = 0;
                for (int i = 0; i < 5; i++) {
                    rank += secondRank[i];
                    if (b <= rank) {
                        sum += secondPrize[i] * 10000;
                        break;
                    }
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
