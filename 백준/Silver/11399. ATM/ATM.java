import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int totalTime = 0;
        int accumulatedTime = 0;

        for (int i = 0; i < N; i++) {
            accumulatedTime += times[i];
            totalTime += accumulatedTime;
        }

        System.out.println(totalTime);
    }
}
