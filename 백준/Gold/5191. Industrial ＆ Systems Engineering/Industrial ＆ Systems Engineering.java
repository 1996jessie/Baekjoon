import java.util.*;

public class Main {
    static int n, m;
    static double[][] storeCoords;
    static double[][] warehouseCoords;
    static double[] buildCost;
    static double[][] dist;
    static double best;

    static void precomputeDistances() {
        dist = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double dx = storeCoords[i][0] - warehouseCoords[j][0];
                double dy = storeCoords[i][1] - warehouseCoords[j][1];
                dist[i][j] = Math.sqrt(dx * dx + dy * dy);
            }
        }
    }

    static void solve() {
        best = Double.MAX_VALUE;
        int totalMasks = 1 << m;
        for (int mask = 1; mask < totalMasks; mask++) {
            double cost = 0.0;
            for (int w = 0; w < m; w++) {
                if ((mask & (1 << w)) != 0) {
                    cost += buildCost[w];
                }
            }
            for (int s = 0; s < n; s++) {
                double minDist = Double.MAX_VALUE;
                for (int w = 0; w < m; w++) {
                    if ((mask & (1 << w)) != 0) {
                        if (dist[s][w] < minDist) minDist = dist[s][w];
                    }
                }
                cost += minDist;
            }
            if (cost < best) best = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int t = 1; t <= K; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            storeCoords = new double[n][2];
            for (int i = 0; i < n; i++) {
                storeCoords[i][0] = sc.nextDouble();
                storeCoords[i][1] = sc.nextDouble();
            }
            warehouseCoords = new double[m][2];
            buildCost = new double[m];
            for (int j = 0; j < m; j++) {
                warehouseCoords[j][0] = sc.nextDouble();
                warehouseCoords[j][1] = sc.nextDouble();
                buildCost[j] = sc.nextDouble();
            }
            precomputeDistances();
            solve();
            System.out.printf("Data Set %d:%n", t);
            System.out.printf("%.2f%n", best);
        }
    }
}
