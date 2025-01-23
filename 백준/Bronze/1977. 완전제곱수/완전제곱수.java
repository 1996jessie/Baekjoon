import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = (int) Math.ceil(Math.sqrt(M)); i <= Math.sqrt(N); i++) {
            int square = i * i;
            sum += square;
            min = Math.min(min, square);
        }
        
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
