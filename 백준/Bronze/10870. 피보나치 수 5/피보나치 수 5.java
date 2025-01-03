import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] fibonacci = new int[n + 1];
        
        fibonacci[0] = 0;
        if (n > 0) {
            fibonacci[1] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        
        System.out.println(fibonacci[n]);
    }
}
