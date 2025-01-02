import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] balloons = new int[N];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            balloons[i] = sc.nextInt();
        }

        LinkedList<Integer> balloonIndices = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            balloonIndices.add(i);
        }

        int currentIndex = 0;

        for (int i = 0; i < N; i++) {
            int currentBalloon = balloonIndices.get(currentIndex);
            result.add(currentBalloon);
            int move = balloons[currentBalloon - 1];

            balloonIndices.remove(currentIndex);

            if (balloonIndices.isEmpty()) {
                break;
            }

            if (balloonIndices.size() > 0) {
                if (move > 0) {
                    currentIndex = (currentIndex + move - 1) % balloonIndices.size();
                } else {
                    currentIndex = (currentIndex + move) % balloonIndices.size();
                    if (currentIndex < 0) {
                        currentIndex += balloonIndices.size();
                    }
                }
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

