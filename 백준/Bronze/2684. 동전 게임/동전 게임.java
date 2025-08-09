import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < P; t++) {
            String s = br.readLine();
            int[] count = new int[8];
            for (int i = 0; i <= 37; i++) {
                String sub = s.substring(i, i + 3);
                int idx = 0;
                if (sub.charAt(0) == 'H') idx += 4;
                if (sub.charAt(1) == 'H') idx += 2;
                if (sub.charAt(2) == 'H') idx += 1;
                count[idx]++;
            }
            for (int i = 0; i < 8; i++) {
                sb.append(count[i]);
                if (i < 7) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
