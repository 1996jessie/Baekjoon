import java.util.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Point[]> segments = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Point p1 = new Point(sc.nextInt(), sc.nextInt());
            Point p2 = new Point(sc.nextInt(), sc.nextInt());
            segments.add(new Point[]{p1, p2});
        }

        boolean[] visited = new boolean[N];
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int groupSize = dfs(i, visited, segments);
                groupSizes.add(groupSize);
            }
        }

        System.out.println(groupSizes.size());
        System.out.println(Collections.max(groupSizes));
    }

    public static int dfs(int idx, boolean[] visited, List<Point[]> segments) {
        Stack<Integer> stack = new Stack<>();
        stack.push(idx);
        visited[idx] = true;
        int groupSize = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            groupSize++;

            for (int i = 0; i < segments.size(); i++) {
                if (!visited[i] && isIntersect(segments.get(current), segments.get(i))) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }

        return groupSize;
    }

    public static boolean isIntersect(Point[] segment1, Point[] segment2) {
        Point p1 = segment1[0], p2 = segment1[1];
        Point p3 = segment2[0], p4 = segment2[1];

        int ccw1 = ccw(p1, p2, p3);
        int ccw2 = ccw(p1, p2, p4);
        int ccw3 = ccw(p3, p4, p1);
        int ccw4 = ccw(p3, p4, p2);

        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
                return onSegment(p1, p2, p3) || onSegment(p1, p2, p4) || onSegment(p3, p4, p1) || onSegment(p3, p4, p2);
            }
            return true;
        }
        return false;
    }

    public static int ccw(Point p1, Point p2, Point p3) {
        long result = (long) p1.x * p2.y + (long) p2.x * p3.y + (long) p3.x * p1.y
                - (long) p1.y * p2.x - (long) p2.y * p3.x - (long) p3.y * p1.x;
        if (result == 0) return 0;
        return result > 0 ? 1 : -1;
    }

    public static boolean onSegment(Point p1, Point p2, Point p) {
        return Math.min(p1.x, p2.x) <= p.x && p.x <= Math.max(p1.x, p2.x)
                && Math.min(p1.y, p2.y) <= p.y && p.y <= Math.max(p1.y, p2.y);
    }
}
