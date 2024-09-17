package week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2961 {

    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[] sour;
    static int[] bitter;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sour = new int[N];
        bitter = new int[N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        simulate(0, 0, 1, 0);

        System.out.println(ans);

    }

    public static void simulate(int depth, int count, int s, int b) {
        if(depth == N) {
            if(count != 0) {
                ans = Math.min(Math.abs(s - b), ans);
            }
            return;
        }

        simulate(depth + 1, count + 1, s * sour[depth], b + bitter[depth]);
        simulate(depth + 1, count, s, b);

    }
}
