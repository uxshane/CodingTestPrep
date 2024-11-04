package columbus_study.finalterm2;

import java.util.Arrays;
import java.util.Scanner;

public class baek_10844 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] arr = new long[N+1][10];
        long mod = 1000000000;

        for(int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0) {
                    arr[i][j] = arr[i-1][1] % mod;
                } else if(j == 9) {
                    arr[i][j] = arr[i-1][8] % mod;
                } else {
                    arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % mod;
                }
            }
        }

        System.out.println(Arrays.stream(arr[N]).sum() % mod);

    }
}
