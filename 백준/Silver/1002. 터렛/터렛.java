import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x2 - x1;
            int dy = y2 - y1;
            int distanceSquared = dx * dx + dy * dy;
            int r1Squared = r1 * r1;
            int r2Squared = r2 * r2;
            int sumR = r1 + r2;
            int diffR = Math.abs(r1 - r2);
            
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if (distanceSquared > sumR * sumR || distanceSquared < diffR * diffR) {
                System.out.println(0);
            } else if (distanceSquared == sumR * sumR || distanceSquared == diffR * diffR) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}
