import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] coords = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        for (int i = 1; i < N; i++) {
            int dx = Math.abs(coords[i][0] - coords[i - 1][0]);
            int dy = Math.abs(coords[i][1] - coords[i - 1][1]);
            total += dx + dy;
        }
        System.out.println(total);
    }
}
