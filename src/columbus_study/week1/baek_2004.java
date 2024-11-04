package columbus_study.week1;

import java.util.Scanner;

public class baek_2004 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long M = sc.nextInt();

        long num2 = cnt2(N) - cnt2(M) - cnt2(N - M);
        long num5 = cnt5(N) - cnt5(M) - cnt5(N - M);

        System.out.println(Math.min(num2, num5));

    }

    public static long cnt5(long n) {
        if(n < 5) return 0;
        long tmp = 0;
        for(long  i = 5; i <= n; i *= 5) {
            tmp += n / i;
        }
        return tmp;
    }

    public static long cnt2(long m) {
        if(m < 2) return 0;
        long tmp = 0;
        for(long  i = 2; i <= m; i *= 2) {
            tmp += m / i;
        }
        return tmp;
    }
}
