package columbus_study.week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1325 {

    static int V, E;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] counter;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new List[V+1];
        counter = new int[V+1];

        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= V; i++) {
            visited = new boolean[V+1];
            q.add(i);
            visited[i] = true;

            while(!q.isEmpty()) {
                int num = q.poll();
                for(int j = 0; j < list[num].size(); j++) {
                    int next = list[num].get(j);
                    if (!visited[next]) {
                        counter[next]++;
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }

        }

        int max = Arrays.stream(counter).max().getAsInt();
        for(int i = 0; i < counter.length; i++) {
            if(counter[i] == max) System.out.print(i + " ");
        }

    }
}
