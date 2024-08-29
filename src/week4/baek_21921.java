package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_21921 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitors = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int currentVisits = 0;
        for(int i = 0; i < X; i++) {
            currentVisits += visitors[i];
        }

        int maxVisited = currentVisits;
        int count = 1;

        for(int i = 0; i < N-X; i++) {
            currentVisits = currentVisits - visitors[i] + visitors[X+i];
            if(currentVisits > maxVisited) {
                maxVisited = currentVisits;
                count = 1;
            } else if(currentVisits == maxVisited) {
                count++;
            }
        }

        if(maxVisited == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisited);
            System.out.println(count);
        }

    }
}
