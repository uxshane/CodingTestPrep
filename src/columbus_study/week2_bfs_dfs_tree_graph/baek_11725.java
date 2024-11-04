package columbus_study.week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_11725 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] result;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        DFS(1);

        for(int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }

    }

    public static void DFS(int start) {
        visited[start] = true;
        for(int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            if(!visited[next]) {
                result[next] = start;
                DFS(next);
            }
        }
    }

}
