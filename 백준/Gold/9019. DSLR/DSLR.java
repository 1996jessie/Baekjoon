import java.io.*;
import java.util.*;

public class Main {
    static String[] commands = {"D", "S", "L", "R"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            System.out.println(bfs(A, B));
        }
    }

    static String bfs(int A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        
        queue.add(A);
        pathQueue.add("");
        visited[A] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            String path = pathQueue.poll();
            
            if (current == B) {
                return path;
            }
            
            for (int i = 0; i < 4; i++) {
                int next = applyCommand(current, i);
                
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    pathQueue.add(path + commands[i]);
                }
            }
        }
        
        return "";
    }
    
    static int applyCommand(int current, int command) {
        switch (command) {
            case 0: return (2 * current) % 10000;
            case 1: return (current - 1 + 10000) % 10000;
            case 2: return (current % 1000) * 10 + current / 1000;
            case 3: return (current % 10) * 1000 + current / 10;
            default: return current;
        }
    }
}
