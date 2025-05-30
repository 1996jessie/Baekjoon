import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(". ").append(br.readLine()).append("\n");
        }
        
        System.out.print(sb);
    }
}
