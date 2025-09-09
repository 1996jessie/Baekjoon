import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());
        Map<Integer, Integer> effectToMed = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int effect = Integer.parseInt(st.nextToken());
            int name = Integer.parseInt(st.nextToken());
            effectToMed.put(effect, name);
        }
        int R = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int Li = Integer.parseInt(st.nextToken());
            List<Integer> meds = new ArrayList<>();
            boolean died = false;
            for (int j = 0; j < Li; j++) {
                int sym = Integer.parseInt(st.nextToken());
                if (effectToMed.containsKey(sym)) {
                    meds.add(effectToMed.get(sym));
                } else {
                    died = true;
                }
            }
            if (died) {
                sb.append("YOU DIED\n");
            } else {
                for (int m : meds) {
                    sb.append(m).append(" ");
                }
                sb.setLength(sb.length() - 1);
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
