import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int idx;
		long data;
		
		public Node(int idx, long data) {
			this.idx = idx;
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Node[] node = new Node[N];
			
			for (int i = 0; i < N; ++i) {
				long data = Long.parseLong(st.nextToken());
				node[i] = new Node(i, data);
			}
			
			Deque<Node> deq = new ArrayDeque<>();
			long ans = -(long) 1e12;
			
			for (int i = 0; i < N; i++) {
				while (!deq.isEmpty() && deq.peekLast().idx + D < i) {
					deq.pollLast();
				}
				
				if (deq.isEmpty()) {
					deq.offer(node[i]);
					continue;
				}
				
				if (deq.peekLast().data <= deq.peekLast().data + node[i].data) {
					deq.addLast(new Node(i, deq.peekLast().data + node[i].data));
				} else {
					while (deq.size() > 1 && deq.peekFirst().data <= deq.peekLast().data + node[i].data) {
						deq.pollFirst();
					}
					deq.addFirst(new Node(i, deq.peekLast().data + node[i].data));
				}
				
				if (deq.peekLast().data <= node[i].data) {
					deq.addLast(new Node(i, node[i].data));
				}
				
				ans = Math.max(ans, deq.peekLast().data);
			}
			bw.write(ans + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
