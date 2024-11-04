package columbus_study.finalterm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baek_2668 {

    static int N, num;
    static int[] area;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        area = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            area[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            num = i;
            DFS(i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }
    }

    private static void DFS(int n) {

        if(area[n] == num) {
            list.add(num);
        }

        if(!visited[area[n]]) {
            visited[area[n]] = true;
            DFS(area[n]);
            visited[area[n]] = false;
        }

    }
}
