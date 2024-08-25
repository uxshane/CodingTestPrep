package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baek_18115 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    dq.addFirst(i);
                    break;
                case 2:
                    int tmp = dq.pollFirst();
                    dq.addFirst(i);
                    dq.addFirst(tmp);
                    break;
                case 3:
                    dq.addLast(i);
                    break;
            }
        }

        for(Integer num : dq) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }
}
