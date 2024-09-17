package week2_bfs_dfs_tree_graph;

import java.util.ArrayList;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        // num of vertex
        int n = 6;

        // edge = [u, v]
        int[][] edge_set = {{1, 2}, {2, 6}, {2, 4}, {4, 3}, {3, 2}, {3, 5}};

        // 2-D Array
        int[][] array = new int[n+1][n+1];

        for(int i = 0; i < n; i++) {
            array[edge_set[i][0]][edge_set[i][1]] = 1;
            array[edge_set[i][1]][edge_set[i][0]] = 1;
        }

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // 인접 리스트 초기화
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선 정보를 인접 리스트에 추가
        for (int[] edge : edge_set) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // 인접 리스트 출력
        for (int i = 1; i <= n; i++) {
            System.out.println("Vertex " + i + ": " + adjList.get(i));
        }

    }
}
