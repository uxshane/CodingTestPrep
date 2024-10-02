package week3_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1600 {

    static int K, W, H;
    static int[][] area;
    static int min = Integer.MAX_VALUE;
    static int[] hdirX = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdirY = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dirX = {0, 1, 0 ,-1};
    static int[] dirY = {1, 0, -1, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[H][W][K+1];

    }

    static

}
