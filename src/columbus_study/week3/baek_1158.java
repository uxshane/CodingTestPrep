package columbus_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baek_1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            dq.add(i);
        }

        sb.append('<');
        while(dq.size() != 1) {
            for(int i = 1; i <= K-1; i++) {
                dq.addLast(dq.pollFirst());
            }
            sb.append(dq.pollFirst()).append(", ");
        }
        sb.append(dq.poll());
        sb.append('>');

        System.out.println(sb.toString());
    }
}
