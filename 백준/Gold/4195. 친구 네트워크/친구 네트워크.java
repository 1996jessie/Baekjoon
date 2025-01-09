import java.io.*;
import java.util.*;

public class Main {
    static Map<String, String> parent;
    static Map<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            size = new HashMap<>();

            for (int i = 0; i < F; i++) {
                String[] relation = br.readLine().split(" ");
                String a = relation[0];
                String b = relation[1];

                if (!parent.containsKey(a)) {
                    parent.put(a, a);
                    size.put(a, 1);
                }
                if (!parent.containsKey(b)) {
                    parent.put(b, b);
                    size.put(b, 1);
                }

                String rootA = find(a);
                String rootB = find(b);

                if (!rootA.equals(rootB)) {
                    union(rootA, rootB);
                }

                sb.append(size.get(find(a))).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    public static String find(String x) {
        if (parent.get(x).equals(x)) {
            return x;
        }
        parent.put(x, find(parent.get(x))); 
        return parent.get(x);
    }

    public static void union(String rootA, String rootB) {
        if (rootA.equals(rootB)) {
            return;
        }

        if (size.get(rootA) > size.get(rootB)) {
            parent.put(rootB, rootA);
            size.put(rootA, size.get(rootA) + size.get(rootB));
        } else {
            parent.put(rootA, rootB);
            size.put(rootB, size.get(rootA) + size.get(rootB));
        }
    }
}
