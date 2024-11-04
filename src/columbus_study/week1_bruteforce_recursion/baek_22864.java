package columbus_study.week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_22864 {

    static int work, tired;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        simulate(A, B, C, M);
        System.out.println(work);
    }

    public static void simulate(int A, int B, int C, int M) {
        int day = 1;

        while(day <= 24) {
            if(tired + A <= M) {
                work += B;
                tired += A;
            } else {
                if(tired - C > 0) {
                    tired -= C;
                } else {
                    tired = 0;
                }
            }
            day++;
        }

    }

}
