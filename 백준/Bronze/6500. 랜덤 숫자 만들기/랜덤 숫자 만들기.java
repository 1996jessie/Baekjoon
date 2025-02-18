import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int a0 = Integer.parseInt(br.readLine());
            if (a0 == 0) {
                break;
            }
            sb.append(middleSquareMethod(a0)).append("\n");
        }
        
        System.out.print(sb);
    }

    private static int middleSquareMethod(int a0) {
        HashSet<Integer> seen = new HashSet<>();
        int count = 0;

        while (!seen.contains(a0)) {
            seen.add(a0);
            count++;
            String squared = String.format("%08d", a0 * a0);
            a0 = Integer.parseInt(squared.substring(2, 6));
        }
        
        return count;
    }
}
