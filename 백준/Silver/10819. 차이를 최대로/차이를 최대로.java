import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[] A, perm;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        perm = new int[N];
        used = new boolean[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        max = 0;
        permute(0);
        System.out.println(max);
    }

    static void permute(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(perm[i - 1] - perm[i]);
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = A[i];
                permute(depth + 1);
                used[i] = false;
            }
        }
    }
}
