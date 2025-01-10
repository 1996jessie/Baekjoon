import java.io.*;
import java.util.*;

public class Main{
    static class node{
        HashMap<String, node> child;
        public node(){
            child = new HashMap<>();
        }
    }
    static int N;
    static node root = new node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            node cur = root;
            for(int j = 0; j < K; j++){
                String temp = st.nextToken();
                if(!cur.child.containsKey(temp)){
                    cur.child.put(temp, new node());
                }
                cur = cur.child.get(temp);
            }
        }

        print(root, "");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void print(node cur, String s){
        ArrayList<String> list = new ArrayList<>(cur.child.keySet());
        Collections.sort(list);
        for(String str : list){
            sb.append(s).append(str).append("\n");
            print(cur.child.get(str), s + "--");
        }
    }
}
