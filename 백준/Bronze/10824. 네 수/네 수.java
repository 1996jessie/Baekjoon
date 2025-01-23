import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        long AB = Long.parseLong(input[0] + input[1]);
        long CD = Long.parseLong(input[2] + input[3]);
        
        System.out.println(AB + CD);
    }
}
