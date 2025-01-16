import java.util.*;
 
public class Main {
    
    static ArrayList<Integer> truth = new ArrayList<>();
    static ArrayList<Integer>[] party;
    static int n, m;
    static int total_party;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
 
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            truth.add(scan.nextInt());
        }
 
        party = new ArrayList[m];
        for(int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            
            int num = scan.nextInt();
            for(int j = 0; j < num; j++) {
                party[i].add(scan.nextInt());
            }
        }
 
        total_party = m;
        find_truth();
        System.out.println(total_party);
    }
 
    public static void find_truth() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] party_visited = new boolean[m];
        boolean[] people_visited = new boolean[n + 1];
        for(int i = 0; i < truth.size(); i++) {
            q.offer(truth.get(i));
            people_visited[truth.get(i)] = true;
        }
 
        while(!q.isEmpty()) {
            int current  = q.poll();
 
            for(int i = 0; i < m; i++) {
                if(!party_visited[i] && party[i].contains(Integer.valueOf(current))) {
                    for(int j = 0; j < party[i].size(); j++) {
                        int next = party[i].get(j);
                        if(!people_visited[next]) {
                            people_visited[next] = true;
                            q.offer(next);
                        }
                    }
                    total_party--;
                    party_visited[i] = true;
                }
            }
        }
    }
}