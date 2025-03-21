import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        String[] minusSplits = expression.split("-");

        int result = 0;

        for (int i = 0; i < minusSplits.length; i++) {
            String[] plusSplits = minusSplits[i].split("\\+");
            int sum = 0;

            for (String num : plusSplits) {
                sum += Integer.parseInt(num);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
