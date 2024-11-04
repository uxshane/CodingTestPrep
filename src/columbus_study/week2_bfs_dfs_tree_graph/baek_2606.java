package columbus_study.week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2606 {

    static int[][] array2D;
    static int[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        StringTokenizer st;

        array2D = new int[V][V];
        visited = new int[V];

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            array2D[v1-1][v2-1] = 1;
            array2D[v2-1][v1-1] = 1;
        }

        DFS(0);

        System.out.println(count - 1);

    }

    public static void DFS(int start) {

        if(visited[start] == 1) {
            return;
        }

        visited[start] = 1;
        count++;

        for(int i = 0; i < visited.length; i++) {
            if(visited[i] != 1 && array2D[start][i] == 1) {
                DFS(i);
            }
        }
    }

}
