import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int n = s.length();
        for (int i = 0; i < n; i += 10) {
            int len = Math.min(10, n - i);
            bw.write(s, i, len);
            bw.newLine();
        }
        bw.flush();
    }
}
