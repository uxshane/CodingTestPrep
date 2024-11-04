package columbus_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class baek_18258 {
    public static void main(String[] args) throws IOException {

        Deque<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "push":
                    q.offer(Integer.parseInt(str[1]));
                    break;

                case "pop":
                    Integer num = q.poll();
                    if(num == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(num).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    Integer num2 = q.peekFirst();
                    if(num2 == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(num2).append('\n');
                    }
                    break;

                case "back":
                    Integer num3 = q.peekLast();
                    if(num3 == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(num3).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb.toString());

    }
}
