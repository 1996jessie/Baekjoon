import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) {
            parent[pa] = pb;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int caseNum = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            line = br.readLine();
            if(line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            parent = new int[n+1];
            for(int i=1; i<=n; i++) {
                parent[i] = i;
            }
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            Set<Integer> set = new HashSet<>();
            for(int i=1; i<=n; i++) {
                set.add(find(i));
            }
            sb.append("Case ").append(caseNum).append(": ").append(set.size()).append("\n");
            caseNum++;
        }
        System.out.print(sb.toString());
    }
}
