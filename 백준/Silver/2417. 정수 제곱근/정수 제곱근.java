import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger n = new BigInteger(br.readLine());
        BigInteger low = BigInteger.ZERO;
        BigInteger high = n;
        BigInteger answer = BigInteger.ZERO;

        while (low.compareTo(high) <= 0) {
            BigInteger mid = low.add(high).divide(BigInteger.TWO);
            if (mid.multiply(mid).compareTo(n) >= 0) {
                answer = mid;
                high = mid.subtract(BigInteger.ONE);
            } else {
                low = mid.add(BigInteger.ONE);
            }
        }

        System.out.println(answer);
    }
}
