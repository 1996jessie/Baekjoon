import java.util.*;
import java.lang.Math;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int round(double n) {
        return (int)((n * 10 + 5) / 10);
    }

    static int ccw(Point p1, Point p2, Point p3) {
        return p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y);
    }

    static List<Point> monotonechain(List<Point> dots) {
        Collections.sort(dots, (a, b) -> a.x != b.x ? Integer.compare(a.x, b.x) : Integer.compare(a.y, b.y));

        if (dots.size() <= 1) {
            return dots;
        }

        List<Point> lower = new ArrayList<>();
        for (Point d : dots) {
            while (lower.size() >= 2 && ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), d) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(d);
        }

        List<Point> upper = new ArrayList<>();
        for (int i = dots.size() - 1; i >= 0; i--) {
            Point d = dots.get(i);
            while (upper.size() >= 2 && ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), d) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(d);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        List<Point> result = new ArrayList<>(lower);
        result.addAll(upper);
        return result;
    }

    static double getDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        
        List<Point> buildings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buildings.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        List<Point> convexHull = monotonechain(buildings);
        double s = 0;
        for (int i = 0; i < convexHull.size(); i++) {
            s += getDist(convexHull.get(i), convexHull.get((i + 1) % convexHull.size()));
        }

        s += 2 * Math.PI * l;
        System.out.println(round(s));
    }
}
