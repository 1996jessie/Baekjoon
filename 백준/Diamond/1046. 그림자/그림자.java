import java.io.*;
import java.util.*;

public class Main {
    static int h, w, count = 0;
    static char[][] box;
    static double[] light;
    static List<double[]> p = new ArrayList<>();
    static List<double[]> slopeList = new ArrayList<>();

    public static void search(int x, int y, double[] pos, double[] angle) {
        pos = Arrays.copyOf(pos, 2);
        if (x == -1 || x == w || y == -1 || y == h || box[y][x] == '#') {
            p.add(pos);
            return;
        }
        int x1 = angle[0] > 0 ? x + 1 : x - 1;
        int x2 = angle[0] > 0 ? x + 1 : x;
        int y1 = angle[0] * angle[1] > 0 ? y + 1 : y - 1;
        int y2 = angle[0] * angle[1] > 0 ? y + 1 : y;

        double yNx = pos[1] + angle[1] * (x2 - pos[0]);
        double xNy = pos[0] + (y2 - pos[1]) / angle[1];

        if (y + 1e-7 < yNx && yNx < y + 1 - 1e-7 && (xNy < x - 1e-7 || xNy > x + 1 + 1e-7)) {
            pos[0] = x2;
            pos[1] = yNx;
            search(x1, y, pos, angle);
        } else if (x + 1e-7 < xNy && xNy < x + 1 - 1e-7 && (y - 1e-7 > yNx || yNx > y + 1 + 1e-7)) {
            pos[0] = xNy;
            pos[1] = y2;
            search(x, y1, pos, angle);
        } else {
            pos[0] = x2;
            pos[1] = y2;
            if (angle[1] > 0 && (x1 == -1 || x1 == w || box[y][x1] == '#')) {
                p.add(pos);
            }
            if (angle[1] < 0 && (y1 == -1 || y1 == h || box[y1][x] == '#')) {
                p.add(pos);
            }
            search(x1, y1, pos, angle);
            if (angle[1] > 0 && (y1 == -1 || y1 == h || box[y1][x] == '#')) {
                p.add(pos);
            }
            if (angle[1] < 0 && (x1 == -1 || x1 == w || box[y][x1] == '#')) {
                p.add(pos);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dims = br.readLine().split(" ");
        h = Integer.parseInt(dims[0]);
        w = Integer.parseInt(dims[1]);
        box = new char[h][w];
        light = new double[2];

        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            box[i] = line.toCharArray();
            for (int j = 0; j < w; j++) {
                if (box[i][j] == '*') {
                    light[0] = j + 0.5;
                    light[1] = i + 0.5;
                } else if (box[i][j] == '#') {
                    count++;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double[] slope = new double[2];
                double jValue = w * j;
                double iValue = h * i;
                slope[0] = jValue - light[0] > 0 ? 1 : -1;
                slope[1] = (iValue - light[1]) / (jValue - light[0]);
                slopeList.add(slope);
            }
        }

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                double[] slope = new double[2];
                slope[0] = j - light[0] > 0 ? 1 : -1;
                slope[1] = (i - light[1]) / (j - light[0]);
                boolean found = false;
                for (double[] s : slopeList) {
                    if (Arrays.equals(s, slope)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    slopeList.add(slope);
                }
            }
        }

        slopeList.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Double.compare(a[0], b[0]);
            }
            return Double.compare(a[1], b[1]);
        });

        for (double[] slope : slopeList) {
            search((int) light[0], (int) light[1], light, slope);
        }

        double result = 0;
        for (int i = 0; i < p.size(); i++) {
            int j = (i + 1) % p.size();
            result += Math.abs(
                (light[0] * p.get(i)[1] + p.get(i)[0] * p.get(j)[1] + p.get(j)[0] * light[1]) -
                (p.get(i)[0] * light[1] + p.get(j)[0] * p.get(i)[1] + light[0] * p.get(j)[1])
            ) / 2;
        }

        System.out.printf("%.13f%n", w * h - result - count);
    }
}
