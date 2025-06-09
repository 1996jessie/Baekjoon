import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] pref;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        pref = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                pref[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(new ArrayList<>(), 0);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void comb(List<Integer> selected, int start) {
        if (selected.size() >= 1 && selected.size() <= 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int maxPref = 0;
                for (int chicken : selected) {
                    if (pref[i][chicken] > maxPref) {
                        maxPref = pref[i][chicken];
                    }
                }
                sum += maxPref;
            }
            if (sum > result) {
                result = sum;
            }
        }

        if (selected.size() == 3) {
            return;
        }

        for (int i = start; i < M; i++) {
            selected.add(i);
            comb(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
