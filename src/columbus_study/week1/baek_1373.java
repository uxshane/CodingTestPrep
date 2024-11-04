package columbus_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1373 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int M = input.length() % 3;
        StringBuilder sb = new StringBuilder();

        if(M > 0) {
            for(int i = 0; i < 3-M; i++) {
                input = "0" + input;
            }
        }
        for (int i = 0; i < input.length(); i+=3) {
            int first = Integer.parseInt(String.valueOf(input.charAt(i))) << 2;
            int second = Integer.parseInt(String.valueOf(input.charAt(i+1))) << 1;
            int third = Integer.parseInt(String.valueOf(input.charAt(i+2))) << 0;
            sb.append(first+second+third);

        }

        System.out.println(sb.toString());
    }
}
