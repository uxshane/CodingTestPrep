package week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1260 {

    static int N, M, V;
    static int[][] list;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a][b] = 1;
            list[b][a] = 1;
        }

        sb = new StringBuilder();
        DFS(V);
        System.out.println(sb);
        sb = new StringBuilder();
        BFS(V);
        System.out.println(sb);
    }

    public static void BFS(int n) {

        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];

        visited[V] = true;
        q.add(V);

        while(!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");

            for(int i = 1; i <= N; i++) {
                if(list[num][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void DFS(int n) {
        visited[n] = true;
        sb.append(n).append(" ");

        for(int i = 0; i <= N; i++) {
            if(list[n][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }

    }

}
