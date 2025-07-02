import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String a = input[0];
        String b = input[1];

        String minA = a.replace('6', '5');
        String minB = b.replace('6', '5');
        String maxA = a.replace('5', '6');
        String maxB = b.replace('5', '6');

        int minSum = Integer.parseInt(minA) + Integer.parseInt(minB);
        int maxSum = Integer.parseInt(maxA) + Integer.parseInt(maxB);

        System.out.println(minSum + " " + maxSum);
    }
}
