package week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2178 {

    static int N, M;
    static int[][] area;
    static boolean[][] visited;

    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                area[i][j] = line.charAt(j) - '0';
            }
        }


        BFS(0, 0);

        System.out.println(area[N-1][M-1]);

    }

    static class Cords {
        int x;
        int y;

        public Cords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y) {
        visited[y][x] = true;
        Queue<Cords> q = new LinkedList<>();
        q.add(new Cords(x, y));

        while(!q.isEmpty()) {
            Cords cords = q.poll();
            int curX = cords.x;
            int curY = cords.y;

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    if(area[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                        q.add(new Cords(nextX, nextY));
                        visited[nextY][nextX] = true;
                        area[nextY][nextX] = area[curY][curX] + 1;
                    }
                }
            }
        }

    }

}
