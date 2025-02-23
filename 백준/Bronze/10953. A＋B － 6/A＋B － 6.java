import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(",");
            sb.append(Integer.parseInt(input[0]) + Integer.parseInt(input[1])).append("\n");
        }
        
        System.out.print(sb);
    }
}
