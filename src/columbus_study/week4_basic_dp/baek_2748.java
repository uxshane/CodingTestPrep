package columbus_study.week4_basic_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2748 {

    static Long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new Long[N+1];
        arr[0] = 0L;
        arr[1] = 1L;

        System.out.println(fibonacci(N));
    }

    static long fibonacci(int n) {
        if(arr[n] == null) {
            arr[n] = fibonacci(n-1) + fibonacci(n-2);
        }

        return arr[n];
    }

}
