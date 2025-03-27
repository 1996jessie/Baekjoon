import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);
        int gcdValue = numbers[1] - numbers[0];

        for (int i = 2; i < N; i++) {
            gcdValue = gcd(gcdValue, numbers[i] - numbers[i - 1]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i * i <= gcdValue; i++) {
            if (gcdValue % i == 0) {
                result.add(i);
                if (i != gcdValue / i) {
                    result.add(gcdValue / i);
                }
            }
        }
        result.add(gcdValue);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int m : result) {
            sb.append(m).append(" ");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
