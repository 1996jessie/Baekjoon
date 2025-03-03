import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] classes = new int[N][5];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;
        int leader = 0;

        for (int i = 0; i < N; i++) {
            Set<Integer> classmates = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 5; k++) {
                    if (classes[i][k] == classes[j][k]) {
                        classmates.add(j);
                        break;
                    }
                }
            }
            if (classmates.size() > maxCount) {
                maxCount = classmates.size();
                leader = i;
            }
        }

        System.out.println(leader + 1);
    }
}
