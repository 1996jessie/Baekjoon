import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bin = br.readLine().trim();
        int len = bin.length();
        int rem = len % 3;
        if (rem != 0) {
            StringBuilder pad = new StringBuilder();
            for (int i = 0; i < 3 - rem; i++) {
                pad.append('0');
            }
            bin = pad + bin;
            len = bin.length();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += 3) {
            int val = (bin.charAt(i) - '0') * 4 + (bin.charAt(i + 1) - '0') * 2 + (bin.charAt(i + 2) - '0');
            sb.append(val);
        }
        int idx = 0;
        while (idx < sb.length() - 1 && sb.charAt(idx) == '0') {
            idx++;
        }
        System.out.println(sb.substring(idx));
    }
}
