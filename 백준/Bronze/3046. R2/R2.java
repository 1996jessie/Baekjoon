import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int R1 = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        
        System.out.println(2 * S - R1);
    }
}
