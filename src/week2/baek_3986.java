package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_3986 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        int count = 0;

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            stack = new Stack<>();
            stack.push(input.charAt(0));
            for(int j = 1; j < input.length(); j++) {
                if(!stack.isEmpty() && input.charAt(j) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(j));
                }
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
