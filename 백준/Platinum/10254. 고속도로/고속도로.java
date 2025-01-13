import java.io.*;
import java.util.*;

public class Main {
    static class D {
        long x, y;

        D(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static D[] d = new D[200010];
    static D[] s = new D[200010];
    static D mi;

    static long ccw(D a, D b, D c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    static boolean cmp(D x, D y) {
        long n = ccw(mi, x, y);
        return (n > 0) || (n == 0 && Math.abs(x.x) + Math.abs(x.y) < Math.abs(y.x) + Math.abs(y.y));
    }

    static long sql(D x, D y) {
        return (y.x - x.x) * (y.x - x.x) + (y.y - x.y) * (y.y - x.y);
    }

    static D add(D a, D b) {
        return new D(a.x + b.x, a.y + b.y);
    }

    static D sub(D a, D b) {
        return new D(a.x - b.x, a.y - b.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int mini = 0;
            mi = new D(99999999, 99999999);
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                d[i] = new D(x, y);
                if (mi.y > d[i].y || (mi.y == d[i].y && mi.x > d[i].x)) {
                    mi = d[i];
                    mini = i;
                }
            }

            swap(d, 0, mini);
            Arrays.sort(d, 1, n, (x, y) -> cmp(x, y) ? -1 : 1);
            int idx = 2;
            s[0] = d[0];
            s[1] = d[1];
            for (int i = 2; i < n; i++) {
                while (idx > 1 && ccw(s[idx - 2], s[idx - 1], d[i]) <= 0) idx--;
                s[idx++] = d[i];
            }
            long mxl = 0;
            int l = 0, r = 1, trig = 0, xa = 0, xb = 0;
            if (idx == 2) {
                bw.write(s[0].x + " " + s[0].y + " " + s[1].x + " " + s[1].y + "\n");
                continue;
            }
            while (trig == 0 || l != 0) {
                if (mxl < sql(s[l], s[r])) {
                    xa = l;
                    xb = r;
                    mxl = sql(s[l], s[r]);
                }
                if (ccw(s[l], s[(l + 1) % idx], sub(add(s[(r + 1) % idx], s[(l + 1) % idx]), s[r])) >= 0) {
                    r = (r + 1) % idx;
                } else {
                    l = (l + 1) % idx;
                }
                if (l != 0) trig = 1;
            }
            bw.write(s[xa].x + " " + s[xa].y + " " + s[xb].x + " " + s[xb].y + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void swap(D[] arr, int i, int j) {
        D temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
