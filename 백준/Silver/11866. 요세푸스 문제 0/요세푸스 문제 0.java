import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int index = 0;
        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            sb.append(list.remove(index));
            
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }
        
        sb.append(">");
        System.out.println(sb.toString());
    }
}
