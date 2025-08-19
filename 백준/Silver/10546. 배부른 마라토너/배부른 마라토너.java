import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            map.put(name, map.get(name) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                System.out.println(key);
                break;
            }
        }
    }
}
