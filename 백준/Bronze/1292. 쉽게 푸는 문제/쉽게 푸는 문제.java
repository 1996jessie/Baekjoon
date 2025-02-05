import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int sum = 0;
        int currentNumber = 1;
        int count = 1;
        int index = 1;

        while (index <= B) {
            for (int i = 0; i < count && index <= B; i++) {
                if (index >= A) {
                    sum += currentNumber;
                }
                index++;
            }
            currentNumber++;
            count++;
        }

        System.out.println(sum);
    }
}
