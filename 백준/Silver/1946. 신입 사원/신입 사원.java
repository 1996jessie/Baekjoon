import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] applicants = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, Comparator.comparingInt(a -> a[0]));

            int count = 1;
            int minInterviewRank = applicants[0][1];

            for (int i = 1; i < n; i++) {
                if (applicants[i][1] < minInterviewRank) {
                    count++;
                    minInterviewRank = applicants[i][1];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
