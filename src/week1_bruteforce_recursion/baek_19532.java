package week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_19532 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()),
            b = Integer.parseInt(st.nextToken()),
            c = Integer.parseInt(st.nextToken()),
            d = Integer.parseInt(st.nextToken()),
            e = Integer.parseInt(st.nextToken()),
            f = Integer.parseInt(st.nextToken());

        for(int i = -999; i <= 999; i++) {
            for(int j = -999; j <= 999; j++) {
                if((a*i) + (b*j) == c && (d*i) + (e*j) == f) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }

    }
}
