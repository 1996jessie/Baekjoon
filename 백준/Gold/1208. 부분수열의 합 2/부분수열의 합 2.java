import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static ArrayList<Long> leftSum = new ArrayList<>();
    static ArrayList<Long> rightSum = new ArrayList<>();

    static void dfs(int start, int end, long sum, ArrayList<Long> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        dfs(start + 1, end, sum, list);
        dfs(start + 1, end, sum + arr[start], list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, N / 2, 0, leftSum);
        dfs(N / 2, N, 0, rightSum);

        Collections.sort(leftSum);
        Collections.sort(rightSum);

        int l = 0;
        int r = rightSum.size() - 1;
        long count = 0;

        while (l < leftSum.size() && r >= 0) {
            long leftVal = leftSum.get(l);
            long rightVal = rightSum.get(r);
            long total = leftVal + rightVal;

            if (total == S) {
                long cntL = 0;
                long cntR = 0;
                while (l < leftSum.size() && leftSum.get(l) == leftVal) {
                    cntL++;
                    l++;
                }
                while (r >= 0 && rightSum.get(r) == rightVal) {
                    cntR++;
                    r--;
                }
                count += cntL * cntR;
            } else if (total < S) {
                l++;
            } else {
                r--;
            }
        }

        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }
}
