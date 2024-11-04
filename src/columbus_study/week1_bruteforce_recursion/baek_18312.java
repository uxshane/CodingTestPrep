package columbus_study.week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_18312 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        String K = st.nextToken();

        // 0 <= hour <= 23
        // 0 <= minute <= 59
        // 0 <= second <= 59

        int count = 0;

        boolean hourCheck = false;
        boolean minCheck = false;
        boolean secCheck = false;

        for(int i = 0; i <= hour; i++) {
            if(String.format("%02d", i).contains(K)) {
                hourCheck = true;
            } else {
                hourCheck = false;
            }
            for(int j = 0; j <= 59; j++) {
                if(String.format("%02d", j).contains(K)) {
                    minCheck = true;
                } else {
                    minCheck = false;
                }
                for(int k = 0; k <= 59; k++) {
                    if(String.format("%02d", k).contains(K)) {
                        secCheck = true;
                    } else {
                        secCheck = false;
                    }

                    if(hourCheck || minCheck || secCheck) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);


    }
}
