import java.io.*;
import java.util.*;

public class Main {
    static class Homework implements Comparable<Homework> {
        int day, score;

        Homework(int day, int score) {
            this.day = day;
            this.score = score;
        }

        public int compareTo(Homework o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Homework[] hw = new Homework[n];
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            hw[i] = new Homework(d, w);
            if (d > maxDay) {
                maxDay = d;
            }
        }

        Arrays.sort(hw);
        boolean[] done = new boolean[maxDay + 1];
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = hw[i].day; j >= 1; j--) {
                if (!done[j]) {
                    done[j] = true;
                    total += hw[i].score;
                    break;
                }
            }
        }

        System.out.println(total);
    }
}
