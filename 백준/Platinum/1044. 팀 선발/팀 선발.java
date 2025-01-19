import java.util.*;

public class Main {

    static final int N = 40;
    static long[] a = new long[N], b = new long[N], pp = new long[N];
    static List<Pair<Long, Long>>[] lm = new List[N], rm = new List[N];
    static long lb, rb, ans = 1000000000000000000L;
    static int n;

    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean ord(long a, long b) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            if ((a & pp[i]) != (b & pp[i])) {
                return (a & pp[i]) < (b & pp[i]);
            }
        }
        return false;
    }

    static boolean cmp(Pair<Long, Long> a, Pair<Long, Long> b) {
        if (a.first.equals(b.first)) {
            return ord(a.second, b.second);
        }
        return a.first < b.first;
    }

    static void dp(int i, int e, long k, long bit, int c) {
        if (i == e) {
            if (e == n) rm[c].add(new Pair<>(k, bit));
            else lm[c].add(new Pair<>(k, bit));
            return;
        }
        dp(i + 1, e, k + a[i], bit, c);
        dp(i + 1, e, k - b[i], bit + pp[e - 1 - i], c + 1);
    }

    static void update(Pair<Long, Long> p, Pair<Long, Long> q) {
        long ls = p.first, lbit = p.second;
        long rs = q.first, rbit = q.second;
        long d = Math.abs(ls + rs);
        if (d < ans) {
            ans = d;
            lb = lbit;
            rb = rbit;
        } else if (d == ans) {
            if (ord(lbit, lb)) {
                lb = lbit;
                rb = rbit;
            } else if (lb == lbit && ord(rbit, rb)) {
                lb = lbit;
                rb = rbit;
            }
        }
    }

    static void print(long lb, long rb) {
        int[] s = new int[n];
        for (int i = n / 2 - 1; i >= 0; i--) {
            s[i] = (int)(lb % 2) + 1;
            lb /= 2;
        }
        for (int i = n - 1; i >= n / 2; i--) {
            s[i] = (int)(rb % 2) + 1;
            rb /= 2;
        }
        for (int x : s) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        pp[0] = pp[n / 2] = 1;
        for (int i = 1; i < n / 2; i++) {
            pp[n / 2 + i] = pp[i] = pp[i - 1] * 2;
        }
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }

        for (int i = 0; i < N; i++) {
            lm[i] = new ArrayList<>();
            rm[i] = new ArrayList<>();
        }

        dp(0, n / 2, 0, 0, 0);
        dp(n / 2, n, 0, 0, 0);

        for (List<Pair<Long, Long>> list : lm) {
            list.sort((p1, p2) -> cmp(p1, p2) ? -1 : 1);
        }
        for (List<Pair<Long, Long>> list : rm) {
            list.sort((p1, p2) -> cmp(p1, p2) ? -1 : 1);
        }

        for (int i = 0; i <= n / 2; i++) {
            int j = n / 2 - i;
            for (Pair<Long, Long> p : lm[i]) {
                Pair<Long, Long> r = new Pair<>(-p.first, p.second);
                int ll = lowerBound(rm[j], r);
                int rr = rm[j].size() - 1;
                int s = Math.max(ll - 30, 0);
                int e = Math.min(ll + 10, rr);

                for (int k = s; k <= e; k++) {
                    Pair<Long, Long> q = rm[j].get(k);
                    update(p, q);
                }
            }
        }

        print(lb, rb);
    }

    static int lowerBound(List<Pair<Long, Long>> list, Pair<Long, Long> key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (cmp(list.get(mid), key)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
