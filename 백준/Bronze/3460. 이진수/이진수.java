import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int pos = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    sb.append(pos).append(" ");
                }
                n >>= 1;
                pos++;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
