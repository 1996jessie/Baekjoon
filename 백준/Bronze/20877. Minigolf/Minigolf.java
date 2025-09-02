import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 1; i <= N; i++) {
            int strokes = Integer.parseInt(st.nextToken());
            if (strokes > 7) {
                strokes = 7;
            }
            int par = (i % 2 == 1) ? 2 : 3;
            total += strokes - par;
        }
        System.out.println(total);
    }
}
