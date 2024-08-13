package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_10799 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //스택을 사용해 레이저와 막대기를 구분하여 값을 더해주기.
        Stack<Character> stack = new Stack<>();

        int numOfSticks = 0;
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                stack.pop();
            }

            if(input.charAt(i - 1) == '(' && input.charAt(i) == ')') {
                numOfSticks += stack.size();
            } else if (input.charAt(i - 1) == ')' && input.charAt(i) == ')') {
                numOfSticks++;
            }
        }

        System.out.println(numOfSticks);

    }
}
