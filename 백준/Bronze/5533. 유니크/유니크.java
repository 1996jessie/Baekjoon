import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] score = new int[N];
        for (int game = 0; game < 3; game++) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < N; i++) {
                count.put(nums[i][game], count.getOrDefault(nums[i][game], 0) + 1);
            }
            for (int i = 0; i < N; i++) {
                if (count.get(nums[i][game]) == 1) {
                    score[i] += nums[i][game];
                }
            }
        }

        for (int s : score) {
            System.out.println(s);
        }
    }
}
