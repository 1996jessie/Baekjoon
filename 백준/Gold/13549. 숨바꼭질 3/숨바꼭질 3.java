import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        
        queue.add(new int[]{n, 0});
        
        while (true) {
            int[] current = queue.poll();
            int num = current[0];
            int cnt = current[1];
            
            if (num == k) {
                System.out.println(cnt);
                break;
            }
            
            if (num >= 0 && num < 100001 && !visited[num]) {
                queue.add(new int[]{num * 2, cnt});
                queue.add(new int[]{num - 1, cnt + 1});
                queue.add(new int[]{num + 1, cnt + 1});
                visited[num] = true;
            }
        }
    }
}
