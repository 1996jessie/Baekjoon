import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long hash = 0;
        long r = 31;
        long M = 1234567891;
        long power = 1;

        for (int i = 0; i < L; i++) {
            int value = str.charAt(i) - 'a' + 1;
            hash = (hash + value * power) % M;
            power = (power * r) % M;
        }

        System.out.println(hash);
    }
}
