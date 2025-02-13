import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int totalTime = Arrays.stream(t).sum() + (n - 1) * 8;
        System.out.println((totalTime / 24) + " " + (totalTime % 24));
    }
}
