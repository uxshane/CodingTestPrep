package columbus_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] list = new Integer[N];
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list, Collections.reverseOrder());

        int count = 0;
        for(int i = 0; i < N; i++) {
            int num = K / list[i];
            if(num > 0) {
                count += num;
                K = K - list[i]*num;
            }
        }

        System.out.println(count);

    }
}
