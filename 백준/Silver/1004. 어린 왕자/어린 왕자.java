import java.io.*;
import java.util.*;

public class Main {
    static class Planet {
        int cx, cy, r;
        
        Planet(int cx, int cy, int r) {
            this.cx = cx;
            this.cy = cy;
            this.r = r;
        }
        
        boolean isInside(int x, int y) {
            return (x - cx) * (x - cx) + (y - cy) * (y - cy) < r * r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int n = Integer.parseInt(br.readLine());
            Planet[] planets = new Planet[n];
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                planets[i] = new Planet(cx, cy, r);
            }

            int count = 0;
            
            for (int i = 0; i < n; i++) {
                boolean startInside = planets[i].isInside(x1, y1);
                boolean endInside = planets[i].isInside(x2, y2);
                
                if (startInside != endInside) {
                    count++;
                }
            }

            bw.write(count + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
