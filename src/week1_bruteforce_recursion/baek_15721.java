package week1_bruteforce_recursion;

import java.util.Scanner;

public class baek_15721 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int T = sc.nextInt();
        int P = sc.nextInt();

        int answer = 0;

        int bbun = 0;
        int degi = 0;
        int n = 2;
        oo: while(true) {

            for(int i = 0; i < 4; i++) {
                if(i % 2 == 0) {
                    bbun++;
                    if(bbun == T && P == 0) {
                        answer = (bbun + degi - 1) % A;
                        break oo;
                    }
                } else {
                    degi++;
                    if(degi == T && P == 1) {
                        answer = (bbun + degi - 1) % A;
                        break oo;
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                bbun++;
                if(bbun == T && P == 0) {
                    answer = (bbun + degi - 1) % A;
                    break oo;
                }
            }

            for(int i = 0; i < n; i++) {
                degi++;
                if(degi == T && P == 1) {
                    answer = (bbun + degi - 1) % A;
                    break oo;
                }
            }
            n++;
        }

        System.out.println(answer);

    }
}
