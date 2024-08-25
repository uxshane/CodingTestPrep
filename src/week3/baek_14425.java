package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_14425 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> list = new HashSet<>();
        while(N-- > 0) {
            list.add(br.readLine());
        }

        int count = 0;
        while(M-- > 0) {
            if(list.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
