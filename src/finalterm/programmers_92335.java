package finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class programmers_92335 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        System.out.println(solution(N, K));

    }

    public static int solution(int n, int k) {
        String[] inputSplittedbyZero = Long.toString(n, k).split("0");
        int count = 0;

        oo: for(int i = 0; i < inputSplittedbyZero.length; i++) {
            if(inputSplittedbyZero[i].isBlank() || inputSplittedbyZero[i].isEmpty()) continue;
            long temp = Long.parseLong(inputSplittedbyZero[i]);
            if(temp <= 1) continue;
            for(long j = 2; j <= Math.sqrt(temp); j++) {
                if(temp % j == 0) {
                    continue oo;
                }
            }
            count++;
        }
        return count;
    }

}
