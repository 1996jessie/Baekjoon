import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        int same = 0;

        for (int i = 0; i < N; i++) {
            if (scores[i] > score) {
                rank++;
            } else if (scores[i] == score) {
                continue;
            } else {
                break;
            }
        }

        if (N == P && score <= scores[N - 1]) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
