package columbus_study.week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_25501 {
    public static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            String str = br.readLine();
            sb.append(isPalindrome(str, 0, str.length() - 1)).append(" ").append(count).append('\n');
            count = 0;
        }

        System.out.println(sb.toString());
    }

    public static int isPalindrome(String str, int left, int right) {
        count++;
        if(left >= right) {
            return 1;
        } else if(str.charAt(left) != str.charAt(right)) {
            return 0;
        } else {
            return isPalindrome(str, left + 1, right - 1);
        }
    }
}
