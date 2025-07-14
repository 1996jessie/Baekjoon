import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < L; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int n = Integer.parseInt(br.readLine());

        if (set.contains(n)) {
            System.out.println(0);
            return;
        }

        List<Integer> list = new ArrayList<>(set);
        list.add(0);
        list.add(1001);
        Collections.sort(list);

        int left = 0, right = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < n && n < list.get(i + 1)) {
                left = list.get(i) + 1;
                right = list.get(i + 1) - 1;
                break;
            }
        }

        int count = 0;
        for (int a = left; a <= n; a++) {
            for (int b = n; b <= right; b++) {
                if (a < b) count++;
            }
        }

        System.out.println(count);
    }
}
