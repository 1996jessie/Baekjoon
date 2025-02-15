import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] balance = br.readLine().split(" ");
        int A = Integer.parseInt(balance[0]);
        int B = Integer.parseInt(balance[1]);
        int C = Integer.parseInt(br.readLine());

        int totalBalance = A + B;
        int totalChickenPrice = 2 * C;

        if (totalBalance >= totalChickenPrice) {
            System.out.println(totalBalance - totalChickenPrice);
        } else {
            System.out.println(totalBalance);
        }
    }
}
