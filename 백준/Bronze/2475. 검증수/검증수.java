import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int sum = 0;
        for (String num : input) {
            int n = Integer.parseInt(num);
            sum += n * n;
        }
        
        System.out.println(sum % 10);
    }
}
