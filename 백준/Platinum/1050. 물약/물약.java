import java.io.*;
import java.util.*;

public class Main {

    private static final long INF = (long) 1e9 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] _v = new String[n];
        String[] _w = new String[m];
        List<String> I = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            _v[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            _w[i] = br.readLine();
        }

        List<Pair> v = new ArrayList<>();
        List<PairStringVector> w = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            v.add(parse1(_v[i]));
            I.add(v.get(i).second);
        }
        for (int i = 0; i < m; i++) {
            PairStringVector pair = parse2(_w[i]);
            w.add(pair);
            I.add(pair.name);
            for (Pair p : pair.vector) {
                I.add(p.second);
            }
        }
        Collections.sort(I);
        I = new ArrayList<>(new HashSet<>(I));

        Map<String, Integer> IDX = new HashMap<>();
        for (int i = 0; i < I.size(); i++) {
            IDX.put(I.get(i), i);
        }

        long[] cost = new long[I.size()];
        Arrays.fill(cost, -1);
        for (Pair pair : v) {
            cost[IDX.get(pair.second)] = pair.first;
        }

        while (true) {
            boolean flag = false;
            for (PairStringVector pair : w) {
                long cur = 0;
                for (Pair p : pair.vector) {
                    long t = cost[IDX.get(p.second)];
                    if (t == -1) {
                        cur = -1;
                        break;
                    }
                    cur += p.first * t;
                    if (cur >= INF) {
                        cur = INF;
                    }
                }
                if (cur == -1) continue;
                if (cost[IDX.get(pair.name)] != -1 && cost[IDX.get(pair.name)] <= cur) continue;
                cost[IDX.get(pair.name)] = cur;
                flag = true;
            }
            if (!flag) break;
        }

        if (!I.contains("LOVE")) {
            System.out.println(-1);
        } else {
            System.out.println(cost[IDX.get("LOVE")]);
        }
    }

    private static Pair parse1(String s) {
        int idx = s.indexOf(' ');
        return new Pair(Integer.parseInt(s.substring(idx + 1)), s.substring(0, idx));
    }

    private static PairStringVector parse2(String s) {
        int idx = s.indexOf('=');
        String name = s.substring(0, idx);
        String t = s.substring(idx + 1);
        t = t.replace('+', ' ');
        StringTokenizer st = new StringTokenizer(t);
        List<Pair> v = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            v.add(new Pair(token.charAt(0) & 15, token.substring(1)));
        }
        return new PairStringVector(name, v);
    }

    static class Pair {
        long first;
        String second;

        Pair(long first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    static class PairStringVector {
        String name;
        List<Pair> vector;

        PairStringVector(String name, List<Pair> vector) {
            this.name = name;
            this.vector = vector;
        }
    }
}
