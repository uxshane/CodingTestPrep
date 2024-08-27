package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2559 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] tempList = new int[N];
        for(int i = 0; i < N; i++) {
            tempList[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= N-K; i++) {
            int count = 0;
            for(int j = i; j < K + i; j++) {
                count += tempList[j];
            }
            max = Math.max(count, max);
        }

        System.out.println(max);
    }
}
