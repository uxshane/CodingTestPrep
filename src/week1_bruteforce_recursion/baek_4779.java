package week1_bruteforce_recursion;

import java.util.Scanner;

public class baek_4779 {
    static int N = 0;
    static int power = 0;
    static StringBuilder str;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            N = sc.nextInt();
            power = (int) Math.pow(3, N);
            str = new StringBuilder("-".repeat(power));

            cantour(0, power);
            System.out.println(str);
        }

    }

    public static void cantour(int start, int n) {
        int div = n / 3;
        if(div == 0) {
            return;
        }
        for(int i = start + div; i < start + div*2; i++) {
            str.setCharAt(i, ' ');
        }

        cantour(start, div);
        cantour(start + div*2, div);
    }

}
