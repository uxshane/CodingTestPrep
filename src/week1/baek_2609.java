package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2609 {
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        int gcd_num = gcd(numbers[0], numbers[1]);
        System.out.println(gcd_num);
        System.out.println((numbers[0]*numbers[1]) / gcd_num);
    }
}
