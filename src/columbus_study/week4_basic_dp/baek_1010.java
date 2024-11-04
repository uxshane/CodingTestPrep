package columbus_study.week4_basic_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1010 {

    static int[][] area = new int[31][31];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(combination(M, N));
        }

    }

    static int combination(int n , int r) {
        if(area[n][r] > 0) {
            return area[n][r];
        } else if (n == r || r == 0) {
            return area[n][r] = 1;
        } else {
            return area[n][r] = combination(n-1, r-1) + combination(n-1, r);
        }
    }
}
