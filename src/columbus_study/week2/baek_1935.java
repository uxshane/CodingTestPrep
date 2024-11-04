package columbus_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class baek_1935 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        Stack<Double> s = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            map.put((char)('A' + i), Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                s.push((double)map.get(c));
            } else {
                switch (c) {
                    case '+':
                        s.push(s.pop() + s.pop());
                        break;
                    case '-':
                        double a = s.pop();
                        double b = s.pop();
                        s.push(b - a);
                        break;
                    case '*':
                        s.push(s.pop() * s.pop());
                        break;
                    case '/':
                        double d = s.pop();
                        double e = s.pop();
                        s.push(e / d);
                        break;
                }
            }
        }
        System.out.printf("%.2f", s.pop());
    }
}
