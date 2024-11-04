package columbus_study.week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberAsString = br.readLine();
        int numberToSubtract = numberAsString.length() * 9;

        int number = Integer.parseInt(numberAsString);

        for(int i = number - numberToSubtract; i < number; i++) {
            int tmp = i;
            int sum = 0;

            while(tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if(i + sum == number) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
