package columbus_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        while(num-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                int p_num = Integer.parseInt(st.nextToken());
                q.offer(new int[] {i, p_num});
            }

            int printCount = 0;
            while(!q.isEmpty()) {
                int[] front = q.poll();
                boolean check = true;

                for(int i = 0; i < q.size(); i++) {
                    if(q.get(i)[1] > front[1]) {
                        q.offer(front);
                        for(int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }
                        check = false;
                        break;
                    }
                }

                if(check == false) {
                    continue;
                }

                printCount++;
                if(front[0] == M) break;
            }
            System.out.println(printCount);
        }


    }
}
