package columbus_study.week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_11724 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] result;
    static int N, M;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                BFS(i);
                count++;
            }
        }

        System.out.println(count);

    }

    public static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()) {
            int num = q.poll();
            for(int i = 0; i < list[num].size(); i++) {
                int a = list[num].get(i);
                if(!visited[a]) {
                    q.add(a);
                    visited[a] = true;
                }
            }
        }
    }

}
