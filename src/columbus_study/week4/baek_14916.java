package columbus_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_14916 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1 || N == 3) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        int num = N % 5;
        if(num % 2 == 0) {
            count += N / 5;
            N -= count*5;
            count += N / 2;
        } else {
            count += (N / 5) - 1;
            N -= count*5;
            count += N / 2;
        }

        System.out.println(count);
    }
}
