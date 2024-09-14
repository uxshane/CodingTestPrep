package week1_bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class baek_5568 {

    static String[] list;
    static Set<String> result;
    static boolean[] visited;
    static int n, k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        list = new String[n];
        visited = new boolean[n];
        result = new HashSet<>();

        for(int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }

        simulate("", 0);

        System.out.println(result.size());

    }

    public static void simulate(String s, int level) {
        if(level == k) {
            result.add(s);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                simulate(s + list[i], level + 1);
                visited[i] = false;
            }
        }
    }

}
