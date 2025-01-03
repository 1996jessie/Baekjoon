import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int sum = 0, min = 4000, max = -4000;

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        Arrays.sort(numbers);
        int mean = (int) Math.round((double) sum / N);
        int median = numbers[N / 2];
        int range = max - min;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Collections.max(freqMap.values());
        ArrayList<Integer> modeCandidates = new ArrayList<>();
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreq) {
                modeCandidates.add(key);
            }
        }

        Collections.sort(modeCandidates);
        int mode;
        if (modeCandidates.size() > 1) {
            mode = modeCandidates.get(1);
        } else {
            mode = modeCandidates.get(0);
        }

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
