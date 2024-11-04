package columbus_study.week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_18511 {

    static int N = 0;
    static int K = 0;
    static int ans = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int num) {
        if(num > N) return;
        if(ans <= num) ans = num;

        for(int i = 0; i < K; i++) {
            dfs(num * 10 + arr[i]);
        }
    }

}
