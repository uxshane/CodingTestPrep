package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class baek_1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int start = 0;

        for(int k = 0; k < N; k++) {
            int given = Integer.parseInt(br.readLine());
            if(start < given) {
                for(int i = start + 1; i <= given; i++) {
                    s.push(i);
                    sb.append('+').append('\n');
                }
                start = given;

            } else if(s.peek() != given) {
                System.out.println("NO");
                return;
            }
            s.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb.toString());
    }
}
