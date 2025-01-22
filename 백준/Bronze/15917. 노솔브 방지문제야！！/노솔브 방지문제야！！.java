import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            long a = Long.parseLong(br.readLine());
            if ((a & (a - 1)) == 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}
