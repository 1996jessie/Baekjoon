import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] roadLengths = new long[N - 1];
        long[] prices = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            roadLengths[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long currentPrice = prices[0];

        for (int i = 0; i < N - 1; i++) {
            if (prices[i] < currentPrice) {
                currentPrice = prices[i];
            }
            totalCost += currentPrice * roadLengths[i];
        }

        System.out.println(totalCost);
    }
}
