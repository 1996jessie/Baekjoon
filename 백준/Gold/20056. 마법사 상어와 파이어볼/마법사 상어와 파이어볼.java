import java.io.*;
import java.util.*;

public class Main {
    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static List<Fireball> fireballs = new ArrayList<>();
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {
            Map<String, List<Fireball>> map = new HashMap<>();

            for (Fireball fb : fireballs) {
                int nr = (fb.r + dr[fb.d] * fb.s % N + N) % N;
                int nc = (fb.c + dc[fb.d] * fb.s % N + N) % N;
                String key = nr + "," + nc;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
            }

            fireballs.clear();

            for (String key : map.keySet()) {
                List<Fireball> list = map.get(key);
                if (list.size() == 1) {
                    fireballs.add(list.get(0));
                } else {
                    int sumM = 0;
                    int sumS = 0;
                    boolean allEven = true;
                    boolean allOdd = true;

                    for (Fireball fb : list) {
                        sumM += fb.m;
                        sumS += fb.s;
                        if (fb.d % 2 == 0) {
                            allOdd = false;
                        } else {
                            allEven = false;
                        }
                    }

                    int nm = sumM / 5;
                    if (nm == 0) {
                        continue;
                    }

                    int ns = sumS / list.size();
                    int[] nds = allEven || allOdd ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                    String[] pos = key.split(",");
                    int r = Integer.parseInt(pos[0]);
                    int c = Integer.parseInt(pos[1]);

                    for (int d : nds) {
                        fireballs.add(new Fireball(r, c, nm, ns, d));
                    }
                }
            }
        }

        int result = 0;
        for (Fireball fb : fireballs) {
            result += fb.m;
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
