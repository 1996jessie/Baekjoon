import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger total = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine());

        BigInteger klaudia = total.add(diff).divide(BigInteger.TWO);
        BigInteger natalia = total.subtract(klaudia);

        System.out.println(klaudia);
        System.out.println(natalia);
    }
}
