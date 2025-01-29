import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        boolean ascending = true;
        boolean descending = true;
        
        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(input[i]);
            if (num != i + 1) {
                ascending = false;
            }
            if (num != 8 - i) {
                descending = false;
            }
        }
        
        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
