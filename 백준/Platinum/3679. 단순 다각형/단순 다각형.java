import java.util.*;

class Main {
    static class Point {
        int idx;
        long x, y;

        Point(int idx, long x, long y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
    }

    static int compAscXAscY(Point a, Point b) {
        if (a.x == b.x) {
            return Long.compare(a.y, b.y);
        } else {
            return Long.compare(a.x, b.x);
        }
    }

    static int comp(Point a, Point b, Point p0) {
        long res = ccw(p0.x, p0.y, a.x, a.y, b.x, b.y);
        if (res == 0) {
            if (a.x == b.x) {
                return Long.compare(a.y, b.y);
            } else {
                return Long.compare(a.x, b.x);
            }
        } else {
            return Long.compare(res, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Point> pos = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                pos.add(new Point(i, x, y));
            }

            pos.sort(Main::compAscXAscY);
            Point p0 = pos.get(0);
            pos.subList(1, n).sort((a, b) -> Main.comp(a, b, p0));

            int i = n - 2;
            while (i >= 0 && ccw(p0.x, p0.y, pos.get(i).x, pos.get(i).y, pos.get(i + 1).x, pos.get(i + 1).y) == 0) {
                i--;
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(pos.get(j).idx + " ");
            }
            for (int j = n - 1; j > i; j--) {
                System.out.print(pos.get(j).idx + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
