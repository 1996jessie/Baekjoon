import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] nutrients, addedNutrients;
    static PriorityQueue<Tree> trees;
    static Queue<Tree> deadTrees;
    static Queue<Tree> newTrees;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nutrients = new int[N][N];
        addedNutrients = new int[N][N];
        trees = new PriorityQueue<>();
        deadTrees = new LinkedList<>();
        newTrees = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                addedNutrients[i][j] = Integer.parseInt(st.nextToken());
                nutrients[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.offer(new Tree(x, y, age));
        }

        for (int year = 0; year < K; year++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    static void spring() {
        Queue<Tree> survivedTrees = new LinkedList<>();
        while (!trees.isEmpty()) {
            Tree tree = trees.poll();
            if (nutrients[tree.x][tree.y] >= tree.age) {
                nutrients[tree.x][tree.y] -= tree.age;
                tree.age++;
                survivedTrees.offer(tree);
            } else {
                deadTrees.offer(tree);
            }
        }
        trees.addAll(survivedTrees);
    }

    static void summer() {
        while (!deadTrees.isEmpty()) {
            Tree tree = deadTrees.poll();
            nutrients[tree.x][tree.y] += tree.age / 2;
        }
    }

    static void fall() {
        Queue<Tree> nextTrees = new LinkedList<>();
        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = tree.x + dx[d];
                    int ny = tree.y + dy[d];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        newTrees.offer(new Tree(nx, ny, 1));
                    }
                }
            }
            nextTrees.offer(tree);
        }
        trees.clear();
        trees.addAll(newTrees);
        trees.addAll(nextTrees);
        newTrees.clear();
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrients[i][j] += addedNutrients[i][j];
            }
        }
    }
}
