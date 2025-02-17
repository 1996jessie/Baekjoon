import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] words = br.readLine().split(" ");
            for (int j = 0; j < words.length; j++) {
                bw.write(new StringBuilder(words[j]).reverse().toString());
                if (j < words.length - 1) {
                    bw.write(" ");
                }
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
