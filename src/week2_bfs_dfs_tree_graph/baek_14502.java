package week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14502 {

    static int N, M;
    static int[][] laboratory;

    static int safeZone = 0;

    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        laboratory = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(safeZone);

    }

    public static void DFS(int wall) {
        if(wall == 3) {
            BFS();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(laboratory[i][j] == 0) {
                    laboratory[i][j] = 1;
                    DFS(wall + 1);
                    laboratory[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(laboratory[i][j] == 2) {
                    q.add(new Point(j, i));
                }
            }
        }

        int[][] copyLab = new int[N][M];
        for(int i = 0; i < N; i++) {
            System.arraycopy(laboratory[i], 0, copyLab[i], 0, M);
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            int curX = p.x;
            int curY = p.y;
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    if(copyLab[nextY][nextX] == 0) {
                        q.add(new Point(nextX, nextY));
                        copyLab[nextY][nextX] = 2;
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyLab[i][j] == 0) {
                    count++;
                }
            }
        }

        safeZone = Math.max(count, safeZone);

    }

}
