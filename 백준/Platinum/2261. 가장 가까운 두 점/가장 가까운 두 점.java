import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }

    static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        Arrays.sort(points);
        System.out.println(closestPair(0, n - 1));
    }

    static int dist(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    static int closestPair(int left, int right) {
        if (left == right) return Integer.MAX_VALUE;
        if (right - left == 1) return dist(points[left], points[right]);

        int mid = (left + right) / 2;
        int minDist = Math.min(closestPair(left, mid), closestPair(mid + 1, right));

        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int dx = points[i].x - points[mid].x;
            if (dx * dx < minDist) strip.add(points[i]);
        }
        strip.sort(Comparator.comparingInt(p -> p.y));

        int size = strip.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip.get(j).y - strip.get(i).y) * (strip.get(j).y - strip.get(i).y) < minDist; j++) {
                minDist = Math.min(minDist, dist(strip.get(i), strip.get(j)));
            }
        }
        return minDist;
    }
}
