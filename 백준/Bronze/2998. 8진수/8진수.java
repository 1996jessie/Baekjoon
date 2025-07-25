import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();

        int len = binary.length();
        int mod = len % 3;
        if (mod == 1) {
            binary = "00" + binary;
        } else if (mod == 2) {
            binary = "0" + binary;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 3) {
            int val = (binary.charAt(i) - '0') * 4 + (binary.charAt(i + 1) - '0') * 2 + (binary.charAt(i + 2) - '0');
            sb.append(val);
        }

        System.out.println(sb.toString());
    }
}
