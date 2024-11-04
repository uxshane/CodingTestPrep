package columbus_study.week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_6603 {

    static int K;
    static int[] S;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            S = new int[K];
            for(int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            DFS("", 0, 0);

            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static void DFS(String s, int n, int start) {
        if(n == 6) {
            sb.append(s).append('\n');
            return;
        }

        for(int i = start; i < K; i++) {
            DFS(s + S[i] + " ", n + 1, i + 1);
        }
    }
}
