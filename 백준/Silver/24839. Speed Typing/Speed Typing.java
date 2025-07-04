import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            String I = br.readLine();
            String P = br.readLine();

            int i = 0, p = 0, extra = 0;
            while (i < I.length() && p < P.length()) {
                if (I.charAt(i) == P.charAt(p)) {
                    i++;
                    p++;
                } else {
                    p++;
                    extra++;
                }
            }

            if (i == I.length()) {
                extra += P.length() - p;
                sb.append("Case #").append(tc).append(": ").append(extra).append("\n");
            } else {
                sb.append("Case #").append(tc).append(": IMPOSSIBLE\n");
            }
        }

        System.out.print(sb);
    }
}
