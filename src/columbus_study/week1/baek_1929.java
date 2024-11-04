package columbus_study.week1;

import java.util.Scanner;

public class baek_1929 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        boolean[] primeArr = new boolean[end + 1];

        primeArr[0] = primeArr[1] = true;

        for(int i = 2; i * i <= end; i++) {
            if(!primeArr[i]) {
                for(int j = i * i; j <= end; j += i) {
                    primeArr[i] = true;
                }
            }
        }

        for(int i = start; i <= end; i++) {
            if(!primeArr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }
}
