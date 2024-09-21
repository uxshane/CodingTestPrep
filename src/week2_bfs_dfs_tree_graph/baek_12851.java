package week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baek_12851 {

    static int N, K;
    static int sec = 0;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        if(N < K) {
            DFS(0, Math.abs(K-N), N);
        } else {
            System.out.println(Math.abs(N-K));
            System.out.println(1);
            return;
        }

        Collections.sort(list);

        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(0) == list.get(i)) {
                count++;
            }
        }

        System.out.println(sec);
        System.out.println(count);
    }

    static void DFS(int s, int n, int start) {
        if(n < 0) {
            return;
        }

        if(n == 0) {
            sec = Math.min(sec, s);
            list.add(s);
            return;
        }

        DFS(s + 1, n - 2*start, 2*start);
        DFS(s + 1, n - (start + 1), start + 1);

    }

}
