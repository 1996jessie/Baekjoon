import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] prices = new Integer[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(prices, Collections.reverseOrder());
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 != 2) {
                total += prices[i];
            }
        }
        System.out.println(total);
    }
}
