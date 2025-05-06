import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] skill, compressed, bit;
    static Map<Integer, Integer> skillToIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        skill = new int[N];
        compressed = new int[N];
        List<Integer> skillList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            skill[i] = Integer.parseInt(br.readLine());
            skillList.add(skill[i]);
        }

        Collections.sort(skillList);
        skillToIndex = new HashMap<>();
        int idx = 1;
        for (int s : skillList) {
            if (!skillToIndex.containsKey(s)) {
                skillToIndex.put(s, idx++);
            }
        }

        for (int i = 0; i < N; i++) {
            compressed[i] = skillToIndex.get(skill[i]);
        }

        bit = new int[N + 2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int betterThan = query(compressed[i] - 1);
            sb.append((i + 1 - betterThan)).append('\n');
            update(compressed[i], 1);
        }

        System.out.print(sb);
    }

    static void update(int i, int v) {
        while (i < bit.length) {
            bit[i] += v;
            i += (i & -i);
        }
    }

    static int query(int i) {
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= (i & -i);
        }
        return res;
    }
}
