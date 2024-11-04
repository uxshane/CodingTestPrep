package columbus_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_13305 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long[] kilometers = new long[N-1];
        long[] liters = new long[N];

        liters[0] = Long.parseLong(st2.nextToken());
        long min = liters[0];

        for(int i = 0; i < N-1; i++) {
            kilometers[i] = Long.parseLong(st.nextToken());
            long nextLiter = Long.parseLong(st2.nextToken());
            if(nextLiter < min) {
                liters[i+1] = nextLiter;
                min = nextLiter;
            } else {
                liters[i+1] = min;
            }
        }

        long minimumLiters = 0;
        for(int i = 0; i < N-1; i++) {
            minimumLiters += kilometers[i]*liters[i];
        }

        System.out.println(minimumLiters);

    }
}
