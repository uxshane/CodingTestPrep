package columbus_study.week1_bruteforce_recursion;

import java.util.Scanner;

public class baek_17626 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            int min = 5;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, arr[i - j*j]);
            }
            arr[i] = min + 1;
        }

        System.out.println(arr[n]);

    }

}
