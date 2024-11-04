package columbus_study.week1_bruteforce_recursion;

import java.util.Scanner;

public class baek_10870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(fibonacci(N));

    }

    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
