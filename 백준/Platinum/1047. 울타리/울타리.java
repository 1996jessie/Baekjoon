import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = n;

        int[] x = new int[n];
        int[] y = new int[n];
        int[] nfence = new int[n];
        int[] xsort = new int[n];
        int[] ysort = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            nfence[i] = Integer.parseInt(st.nextToken());
            xsort[i] = x[i];
            ysort[i] = y[i];
        }

        Arrays.sort(xsort);
        Arrays.sort(ysort);

        List<Integer> in = new ArrayList<>();

        for (int a = 0; a < n; a++) {
            for (int b = a; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    for (int d = c; d < n; d++) {
                        int ntree = 0;
                        int outSum = 0;
                        int inSum = 0;
                        int need = 2 * (xsort[b] - xsort[a] + ysort[d] - ysort[c]);

                        for (int i = 0; i < n; i++) {
                            if (x[i] >= xsort[a] && x[i] <= xsort[b] &&
                                y[i] >= ysort[c] && y[i] <= ysort[d]) {
                                ntree++;
                                in.add(nfence[i]);
                                inSum += nfence[i];
                            } else {
                                outSum += nfence[i];
                            }
                        }

                        if (outSum >= need) {
                            res = Math.min(res, n - ntree);
                        } else {
                            if (outSum + inSum >= need) {
                                in.sort(Collections.reverseOrder());
                                for (int i = 0; i < in.size(); i++) {
                                    ntree--;
                                    outSum += in.get(i);
                                    if (outSum >= need) {
                                        res = Math.min(res, n - ntree);
                                        break;
                                    }
                                }
                            }
                        }
                        in.clear();
                    }
                }
            }
        }

        System.out.println(res);
    }
}
