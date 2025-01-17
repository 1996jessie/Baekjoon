import java.util.*;

class Main {

    static class Pa implements Comparable<Pa> {
        long x, y, p, q;

        public Pa(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pa t) {
            if (q * t.p == t.q * p) {
                if (x == t.x) {
                    return Long.compare(y, t.y);
                }
                else if (y == t.y) {
                    return Long.compare(x, t.x);
                }
                if (p * q > 0 && t.q * t.p > 0) return Long.compare(y, t.y);
                else return Long.compare(y, t.y);
            }
            return Long.compare(q * t.p, t.q * p);
        }

        public Pa subtract(Pa b) {
            return new Pa(x - b.x, y - b.y);
        }

        public boolean equals(Pa t) {
            return x == t.x && y == t.y;
        }
    }

    static class Line {
        Pa[] pos = new Pa[2];
    }

    public static long ccw2(Pa p, Pa q) {
        return p.x * q.y - p.y * q.x;
    }

    public static int ccw(Pa a, Pa b, Pa c) {
        long tmp = ccw2(b.subtract(a), c.subtract(a));
        if (tmp > 0) return 1;
        else if (tmp == 0) return 0;
        else return -1;
    }

    public static int N, M;
    public static Pa[] pos = new Pa[102];
    public static Pa[] arr = new Pa[102];

    public static boolean between(Pa a, Pa b, Pa c) {
        if (ccw(a, b, c) != 0) return false;
        if (a.x != b.x) {
            return (a.x <= c.x && b.x >= c.x) || (b.x <= c.x && a.x >= c.x);
        } else {
            return (a.y <= c.y && b.y >= c.y) || (b.y <= c.y && a.y >= c.y);
        }
    }

    public static boolean isLineIntersect(Line l1, Line l2) {
        int std1 = ccw(l1.pos[0], l1.pos[1], l2.pos[0]) * ccw(l1.pos[0], l1.pos[1], l2.pos[1]);
        int std2 = ccw(l2.pos[0], l2.pos[1], l1.pos[0]) * ccw(l2.pos[0], l2.pos[1], l1.pos[1]);

        if (std1 <= 0 && std2 <= 0) {
            if (std1 == 0 && std2 == 0) {
                if (between(l1.pos[0], l1.pos[1], l2.pos[0]) || between(l1.pos[0], l1.pos[1], l2.pos[1]) ||
                        between(l2.pos[0], l2.pos[1], l1.pos[0]) || between(l2.pos[0], l2.pos[1], l1.pos[1])) {
                    return true;
                } else return false;
            } else return true;
        } else return false;
    }

    public static boolean isPointInPolygon(Pa P, List<Pa> V) {
        int cnt = 0;

        for (int i = 0; i < V.size(); i++) {
            Line l1 = new Line();
            l1.pos[0] = new Pa(0, 0);
            l1.pos[1] = new Pa(20000, 0);

            Pa p1 = V.get(i).subtract(P);
            Pa p2 = V.get((i + 1) % V.size()).subtract(P);

            if (between(p1, p2, l1.pos[0])) {
                return true;
            }
            if ((p1.y < 0 && p2.y >= 0 && ccw(p1, p2, new Pa(0, 0)) == 1) ||
                    (p2.y < 0 && p1.y >= 0 && ccw(p2, p1, new Pa(0, 0)) == 1)) {
                cnt++;
            }
        }
        return (cnt % 2 == 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();
            for (int i = 0; i < N; i++) {
                arr[i] = new Pa(sc.nextLong(), sc.nextLong());

                if (arr[i].x < arr[0].x) {
                    Pa temp = arr[i];
                    arr[i] = arr[0];
                    arr[0] = temp;
                } else if (arr[i].x == arr[0].x && arr[i].y < arr[0].y) {
                    Pa temp = arr[i];
                    arr[i] = arr[0];
                    arr[0] = temp;
                }
            }
            for (int i = 1; i < N; i++) {
                arr[i].p = arr[i].x - arr[0].x;
                arr[i].q = arr[i].y - arr[0].y;
            }

            Arrays.sort(arr, 1, N);

            for (int i = 0; i < M; i++) {
                pos[i] = new Pa(sc.nextLong(), sc.nextLong());
                if (pos[i].x < pos[0].x) {
                    Pa temp = pos[i];
                    pos[i] = pos[0];
                    pos[0] = temp;
                } else if (pos[i].x == pos[0].x && pos[i].y < pos[0].y) {
                    Pa temp = pos[i];
                    pos[i] = pos[0];
                    pos[0] = temp;
                }
            }
            for (int i = 1; i < M; i++) {
                pos[i].p = pos[i].x - pos[0].x;
                pos[i].q = pos[i].y - pos[0].y;
            }
            Arrays.sort(pos, 1, M);

            List<Pa> V = new ArrayList<>();
            V.add(arr[0]);
            for (int i = 1; i < N; i++) {
                while (V.size() >= 2 && ccw(V.get(V.size() - 2), V.get(V.size() - 1), arr[i]) <= 0) {
                    V.remove(V.size() - 1);
                }
                V.add(arr[i]);
            }

            List<Pa> V2 = new ArrayList<>();
            V2.add(pos[0]);
            for (int i = 1; i < M; i++) {
                while (V2.size() >= 2 && ccw(V2.get(V2.size() - 2), V2.get(V2.size() - 1), pos[i]) <= 0) {
                    V2.remove(V2.size() - 1);
                }
                V2.add(pos[i]);
            }

            boolean cross = false;

            if (V.size() > 2 && V2.size() > 2) {
                for (Pa p : V) {
                    cross |= isPointInPolygon(p, V2);
                    if (cross) break;
                }
                for (Pa p : V2) {
                    cross |= isPointInPolygon(p, V);
                    if (cross) break;
                }
            } else if (V.size() >= 2 && V2.size() == 2) {
                for (int i = 0; i < V.size() && !cross; i++) {
                    Line l1 = new Line();
                    l1.pos[0] = V.get(i);
                    l1.pos[1] = V.get((i + 1) % V.size());
                    Line l2 = new Line();
                    l2.pos[0] = V2.get(0);
                    l2.pos[1] = V2.get(1);
                    cross |= isLineIntersect(l1, l2);
                }
            } else if (V.size() >= 2 && V2.size() == 1) {
                cross |= isPointInPolygon(V2.get(0), V);
            } else if (V.size() == 2 && V2.size() >= 2) {
                for (int i = 0; i < V2.size() && !cross; i++) {
                    Line l1 = new Line();
                    l1.pos[0] = V2.get(i);
                    l1.pos[1] = V2.get((i + 1) % V2.size());
                    Line l2 = new Line();
                    l2.pos[0] = V.get(0);
                    l2.pos[1] = V.get(1);
                    cross |= isLineIntersect(l1, l2);
                }
            } else if (V.size() == 1 && V2.size() >= 2) {
                cross |= isPointInPolygon(V.get(0), V2);
            }

            System.out.println(cross ? "NO" : "YES");
        }
    }
}
