import java.io.*;
import java.util.*;

public class Main {
    static class Candidate {
        int id, votes, time;

        Candidate(int id, int votes, int time) {
            this.id = id;
            this.votes = votes;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalVotes = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Candidate> frames = new ArrayList<>();
        Map<Integer, Candidate> map = new HashMap<>();

        for (int t = 0; t < totalVotes; t++) {
            int student = Integer.parseInt(st.nextToken());

            if (map.containsKey(student)) {
                map.get(student).votes++;
                continue;
            }

            if (frames.size() == N) {
                frames.sort((a, b) -> a.votes == b.votes ? a.time - b.time : a.votes - b.votes);
                Candidate removed = frames.remove(0);
                map.remove(removed.id);
            }

            Candidate newCandidate = new Candidate(student, 1, t);
            frames.add(newCandidate);
            map.put(student, newCandidate);
        }

        frames.sort(Comparator.comparingInt(a -> a.id));

        StringBuilder sb = new StringBuilder();
        for (Candidate c : frames) {
            sb.append(c.id).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
