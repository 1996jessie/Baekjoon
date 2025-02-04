import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] problems = new int[11][2];
        
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(problems, Comparator.comparingInt(a -> a[0]));

        int totalPenalty = 0, currentTime = 0;
        for (int[] problem : problems) {
            currentTime += problem[0];
            totalPenalty += currentTime + 20 * problem[1];
        }

        System.out.println(totalPenalty);
    }
}
