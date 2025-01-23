import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] binaryNumbers = br.readLine().split(" ");
        
        BigInteger binary1 = new BigInteger(binaryNumbers[0], 2);
        BigInteger binary2 = new BigInteger(binaryNumbers[1], 2);
        BigInteger sum = binary1.add(binary2);
        
        System.out.println(sum.toString(2));
    }
}
