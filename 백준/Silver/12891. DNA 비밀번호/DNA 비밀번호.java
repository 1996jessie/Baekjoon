import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        int[] minCount = new int[4];
        int[] curCount = new int[4];
        int valid = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < p; i++) {
            add(dna[i], curCount);
        }

        int result = 0;
        if (check(curCount, minCount)) {
            result++;
        }

        for (int i = p; i < s; i++) {
            add(dna[i], curCount);
            remove(dna[i - p], curCount);
            if (check(curCount, minCount)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static void add(char c, int[] count) {
        if (c == 'A') {
            count[0]++;
        } else if (c == 'C') {
            count[1]++;
        } else if (c == 'G') {
            count[2]++;
        } else if (c == 'T') {
            count[3]++;
        }
    }

    static void remove(char c, int[] count) {
        if (c == 'A') {
            count[0]--;
        } else if (c == 'C') {
            count[1]--;
        } else if (c == 'G') {
            count[2]--;
        } else if (c == 'T') {
            count[3]--;
        }
    }

    static boolean check(int[] count, int[] minCount) {
        for (int i = 0; i < 4; i++) {
            if (count[i] < minCount[i]) {
                return false;
            }
        }
        return true;
    }
}
