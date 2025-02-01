import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        BigInteger A = new BigInteger(input[0]);
        BigInteger B = new BigInteger(input[1]);
        bw.write(A.add(B).multiply(A.subtract(B)).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
