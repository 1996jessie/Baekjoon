import java.io.*;
import java.util.*;

public class Main {
    static final int BASE_TIME = 100;
    static final int BASE_FEE = 10;
    static final int UNIT_TIME = 50;
    static final int UNIT_FEE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> callRecords = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] timeParts = st.nextToken().split(":");
            int minutes = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
            String name = st.nextToken();

            callRecords.put(name, callRecords.getOrDefault(name, 0) + minutes);
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(callRecords.entrySet());

        sortedList.sort((a, b) -> {
            int feeA = calculateFee(a.getValue());
            int feeB = calculateFee(b.getValue());
            if (feeA != feeB) return Integer.compare(feeB, feeA);
            return a.getKey().compareTo(b.getKey());
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Map.Entry<String, Integer> entry : sortedList) {
            bw.write(entry.getKey() + " " + calculateFee(entry.getValue()) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int calculateFee(int totalMinutes) {
        if (totalMinutes <= BASE_TIME) return BASE_FEE;
        return BASE_FEE + (int) Math.ceil((double) (totalMinutes - BASE_TIME) / UNIT_TIME) * UNIT_FEE;
    }
}
