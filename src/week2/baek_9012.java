package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack;

        oo: for(int i = 0; i < N; i++) {
            String input = br.readLine();
            stack = new Stack<>();
            for(int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == '(') {
                    stack.push(input.charAt(j));
                } else if(input.charAt(j) == ')') {
                    if(stack.size() == 0) {
                        System.out.println("NO");
                        continue oo;
                    }
                    stack.pop();
                }
            }
            System.out.println(stack.size() > 0 ? "NO" : "YES");
        }

    }
}
