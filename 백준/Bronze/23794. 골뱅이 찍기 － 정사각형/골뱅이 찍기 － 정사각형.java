import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        sb.append("@".repeat(N + 2)).append("\n");
        for (int i = 0; i < N; i++) {
            sb.append("@").append(" ".repeat(N)).append("@").append("\n");
        }
        sb.append("@".repeat(N + 2));

        System.out.print(sb);
    }
}
