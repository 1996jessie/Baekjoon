import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        for (long start : list) {
            List<Long> seq = new ArrayList<>();
            seq.add(start);
            Set<Long> used = new HashSet<>();
            used.add(start);
            
            while (seq.size() < n) {
                long last = seq.get(seq.size() - 1);
                if (last % 3 == 0 && list.contains(last / 3) && !used.contains(last / 3)) {
                    seq.add(last / 3);
                    used.add(last / 3);
                } else if (list.contains(last * 2) && !used.contains(last * 2)) {
                    seq.add(last * 2);
                    used.add(last * 2);
                } else {
                    break;
                }
            }

            if (seq.size() == n) {
                for (long num : seq) {
                    System.out.print(num + " ");
                }
                return;
            }
        }
    }
}
