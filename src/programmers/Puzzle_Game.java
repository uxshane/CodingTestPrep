package programmers;

public class Puzzle_Game {

    public static void main(String[] args) {
        int[] diffs = {1, 99999, 100000, 99995};
        int[] times = {9999, 9001, 9999, 9001};
        long limit = 3456789012L;
        System.out.println(solution(diffs, times, limit));
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100000;

        while(min < max) {
            int mid = (min + max) / 2;
            if(limit < calTime(diffs, times, mid)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }

    public static long calTime(int[] diffs, int[] times, int level) {
        long totalTime = times[0];

        for (int i = 1; i < diffs.length; i++) {
            int curDiff = diffs[i];
            int curTime = times[i];
            int prevTime = times[i - 1];

            if (curDiff <= level) {
                totalTime += curTime;
            } else {
                int levDiff = curDiff - level;
                totalTime += (long) (prevTime + curTime) * levDiff + curTime;
            }
        }
        return totalTime;
    }

}
