import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long M = Long.parseLong(br.readLine());
        long left = 0, right = M * 5, result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (countTrailingZeros(mid) >= M) {
                if (countTrailingZeros(mid) == M) {
                    result = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static long countTrailingZeros(long n) {
        long count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
