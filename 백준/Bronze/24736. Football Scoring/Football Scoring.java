import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] visitor = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] home = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int visitorScore = visitor[0] * 6 + visitor[1] * 3 + visitor[2] * 2 + visitor[3] * 1 + visitor[4] * 2;
        int homeScore = home[0] * 6 + home[1] * 3 + home[2] * 2 + home[3] * 1 + home[4] * 2;

        System.out.println(visitorScore + " " + homeScore);
    }
}
