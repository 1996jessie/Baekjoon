import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int num = 1, length = 1;

            while (num % n != 0) {
                num = (num * 10 + 1) % n;
                length++;
            }

            System.out.println(length);
        }
    }
}
