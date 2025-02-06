import java.io.*;
import java.util.*;

public class Main {
    static int H, W, N;
    static int[][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        stickers = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                maxArea = Math.max(maxArea, getMaxStickerArea(stickers[i], stickers[j]));
            }
        }
        System.out.println(maxArea);
    }

    private static int getMaxStickerArea(int[] s1, int[] s2) {
        int[][] rotations = {
            {s1[0], s1[1]}, {s1[1], s1[0]},
            {s2[0], s2[1]}, {s2[1], s2[0]}
        };

        int maxArea = 0;
        for (int r1 = 0; r1 < 2; r1++) {
            for (int r2 = 2; r2 < 4; r2++) {
                int r1H = rotations[r1][0], r1W = rotations[r1][1];
                int r2H = rotations[r2][0], r2W = rotations[r2][1];
                
                if ((r1H + r2H <= H && Math.max(r1W, r2W) <= W) ||
                    (r1W + r2W <= W && Math.max(r1H, r2H) <= H)) {
                    maxArea = Math.max(maxArea, (r1H * r1W) + (r2H * r2W));
                }
            }
        }
        return maxArea;
    }
}
