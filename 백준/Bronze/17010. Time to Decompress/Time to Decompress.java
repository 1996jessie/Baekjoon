import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            char c = input[1].charAt(0);

            sb.append(String.valueOf(c).repeat(N)).append("\n");
        }
        
        System.out.print(sb);
    }
}
