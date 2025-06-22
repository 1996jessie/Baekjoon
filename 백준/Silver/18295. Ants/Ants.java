import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine().trim();
            if (!s.matches("\\d+")) continue;
            try {
                BigInteger bigInt = new BigInteger(s);
                if (bigInt.compareTo(BigInteger.ZERO) >= 0 && bigInt.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
                    set.add(bigInt.intValue());
                }
            } catch (NumberFormatException e) {
                // ignore invalid numbers
            }
        }

        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
