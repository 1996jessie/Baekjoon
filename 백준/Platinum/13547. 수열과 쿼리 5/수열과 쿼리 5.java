import java.io.*;
import java.util.*;

public class Main {
    static class Query implements Comparable<Query> {
        int l, r, idx, block;
        Query(int l, int r, int idx, int blockSize) {
            this.l = l;
            this.r = r;
            this.idx = idx;
            this.block = l / blockSize;
        }
        public int compareTo(Query o) {
            if (this.block != o.block) {
                return this.block - o.block;
            }
            return this.r - o.r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Query[] queries = new Query[M];
        int blockSize = (int)Math.sqrt(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            queries[i] = new Query(l, r, i, blockSize);
        }

        Arrays.sort(queries);

        int[] ans = new int[M];
        int[] freq = new int[1000001];
        int distinct = 0;
        int curL = 1, curR = 0;

        for (Query q : queries) {
            while (curL > q.l) {
                curL--;
                if (freq[arr[curL]]++ == 0) {
                    distinct++;
                }
            }
            while (curR < q.r) {
                curR++;
                if (freq[arr[curR]]++ == 0) {
                    distinct++;
                }
            }
            while (curL < q.l) {
                if (--freq[arr[curL]] == 0) {
                    distinct--;
                }
                curL++;
            }
            while (curR > q.r) {
                if (--freq[arr[curR]] == 0) {
                    distinct--;
                }
                curR--;
            }
            ans[q.idx] = distinct;
        }

        for (int x : ans) {
            bw.write(x + "\n");
        }
        bw.flush();
    }
}
