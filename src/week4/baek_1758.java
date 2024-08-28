package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class baek_1758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] customers = new Integer[N];

        for(int i = 0; i < N; i++) {
            customers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(customers, Collections.reverseOrder());

        long tip = 0;
        for(int i = 1; i <= N; i++) {
            int num = customers[i-1]- (i - 1);
            if(num <= 0) break;
            tip += num;
        }

        System.out.println(tip);
    }
}
