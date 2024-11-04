package columbus_study.midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2960 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] primeList = new boolean[N + 1];

        int count = 0;
        for(int i = 2; i <= N; i++) {
            for(int j = i; j <= N; j += i) {
                if(!primeList[j]) {
                    count++;
                    primeList[j] = true;
                }
                if(count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }

    }
}
