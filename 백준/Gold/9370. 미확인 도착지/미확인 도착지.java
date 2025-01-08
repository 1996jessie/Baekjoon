import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            int ghDistance = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Edge(b, d));
                graph.get(b).add(new Edge(a, d));
                if ((a == g && b == h) || (a == h && b == g)) {
                    ghDistance = d;
                }
            }

            int[] candidates = new int[t];
            for (int i = 0; i < t; i++) {
                candidates[i] = Integer.parseInt(br.readLine());
            }

            int[] distFromS = dijkstra(graph, s, n);
            int[] distFromG = dijkstra(graph, g, n);
            int[] distFromH = dijkstra(graph, h, n);

            List<Integer> results = new ArrayList<>();
            for (int x : candidates) {
                int direct = distFromS[x];
                int viaGtoH = distFromS[g] + ghDistance + distFromH[x];
                int viaHtoG = distFromS[h] + ghDistance + distFromG[x];
                if (direct == viaGtoH || direct == viaHtoG) {
                    results.add(x);
                }
            }

            Collections.sort(results);
            for (int i = 0; i < results.size(); i++) {
                if (i > 0) {
                    bw.write(" ");
                }
                bw.write(String.valueOf(results.get(i)));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dijkstra(List<List<Edge>> graph, int start, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int curNode = current.to;
            int curDist = current.weight;

            if (curDist > dist[curNode]) {
                continue;
            }

            for (Edge edge : graph.get(curNode)) {
                int nextNode = edge.to;
                int newDist = curDist + edge.weight;
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.add(new Edge(nextNode, newDist));
                }
            }
        }

        return dist;
    }
}
