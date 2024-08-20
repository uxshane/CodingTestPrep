package midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while(K-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(!stack.isEmpty() && num == 0) {
                stack.pop();
            } else if(num != 0) {
                stack.push(num);
            }
        }

        int count = 0;
        for(int n : stack) {
            count += n;
        }

        System.out.println(count);

    }
}
