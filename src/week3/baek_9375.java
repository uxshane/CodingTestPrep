package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baek_9375 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int M = Integer.parseInt(br.readLine());
            Map<String, Integer> categoryMap = new HashMap<>();

            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String productName = st.nextToken();
                String category = st.nextToken();
                categoryMap.put(category, categoryMap.getOrDefault(category, 0) + 1);
            }

            int res = 1;
            for(int cat : categoryMap.values()) {
                res *= (cat + 1);
            }
            System.out.println(res - 1);
        }

    }
}
