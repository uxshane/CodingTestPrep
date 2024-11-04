package columbus_study.week3_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_13023 {

    static int N, M;
    static int output;
    static List<Integer>[] friendList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friendList = new List[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            friendList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendList[a].add(b);
            friendList[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            if(output == 0) {
                DFS(1, i);
            }
        }

        System.out.println(output);
    }

    static void DFS(int level, int start) {
        if(level == 5) {
            output = 1;
            return;
        }

        visited[start] = true;
        for(int i = 0; i < friendList[start].size(); i++) {
            int friend = friendList[start].get(i);
            if(!visited[friend]) {
                DFS(level + 1, friend);
            }
        }
        visited[start] = false;

    }

}
