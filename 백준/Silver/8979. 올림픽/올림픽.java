import java.io.*;
import java.util.*;

public class Main {
    static class Country {
        int id, gold, silver, bronze;
        Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            countries[i] = new Country(id,g,s,b);
        }
        Country target = null;
        for(Country c : countries) {
            if(c.id == K) {
                target = c;
                break;
            }
        }
        int rank = 1;
        for(Country c : countries) {
            if(c.id != target.id) {
                if(c.gold > target.gold) {
                    rank++;
                } else if(c.gold == target.gold) {
                    if(c.silver > target.silver) {
                        rank++;
                    } else if(c.silver == target.silver) {
                        if(c.bronze > target.bronze) {
                            rank++;
                        }
                    }
                }
            }
        }
        System.out.println(rank);
    }
}
