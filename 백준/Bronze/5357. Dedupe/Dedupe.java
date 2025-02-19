import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            String s = br.readLine();
            StringBuilder result = new StringBuilder();
            char prev = 0;
            
            for (char c : s.toCharArray()) {
                if (c != prev) {
                    result.append(c);
                    prev = c;
                }
            }
            
            sb.append(result).append("\n");
        }
        
        System.out.print(sb);
    }
}
