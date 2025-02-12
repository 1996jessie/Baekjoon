import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            char decoded = (char) (c - 3);
            if (decoded < 'A') {
                decoded += 26;
            }
            result.append(decoded);
        }

        bw.write(result.toString() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
