package columbus_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_1918 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(c == '(') {
                s.push(c);
                continue;
            }

            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
                continue;
            }

            if(c == ')') {
                while(!s.isEmpty() && s.peek() != '(') {
                    sb.append(s.pop());
                }
                s.pop();
                continue;
            }

            if(c == '+' || c == '-' || c == '*' || c == '/') {
                while(!s.isEmpty() && priorOperator(s.peek()) >= priorOperator(c)) {
                    sb.append(s.pop());
                }
                s.push(c);
            }

        }
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb.toString());
    }

    public static int priorOperator(char c) {
        if(c == '*' || c == '/') {
            return 2;
        } else if(c == '+' || c == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}
