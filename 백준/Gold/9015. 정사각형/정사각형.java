import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Set<Long> pointSet = new HashSet<>();
    static final int OFFSET = 10000;
    static final int SIZE = 20001;

    static long encode(int x, int y) {
        return 1L * (x + OFFSET) * SIZE + (y + OFFSET);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Point[] points = new Point[N];
            pointSet.clear();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
                pointSet.add(encode(x, y));
            }

            int maxArea = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int dx = points[j].x - points[i].x;
                    int dy = points[j].y - points[i].y;

                    int rx = -dy;
                    int ry = dx;

                    int x3 = points[i].x + rx;
                    int y3 = points[i].y + ry;
                    int x4 = points[j].x + rx;
                    int y4 = points[j].y + ry;

                    if (pointSet.contains(encode(x3, y3)) && pointSet.contains(encode(x4, y4))) {
                        maxArea = Math.max(maxArea, dx * dx + dy * dy);
                    }

                    x3 = points[i].x - rx;
                    y3 = points[i].y - ry;
                    x4 = points[j].x - rx;
                    y4 = points[j].y - ry;

                    if (pointSet.contains(encode(x3, y3)) && pointSet.contains(encode(x4, y4))) {
                        maxArea = Math.max(maxArea, dx * dx + dy * dy);
                    }
                }
            }

            sb.append(maxArea).append("\n");
        }

        System.out.print(sb);
    }
}
