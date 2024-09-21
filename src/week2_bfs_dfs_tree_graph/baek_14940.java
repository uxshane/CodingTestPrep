package week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14940 {

    static int N, M;
    static Point target;
    static int[][] area;
    static boolean[][] visited;

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                area[i][j] = num;
                if(num == 2) {
                    target = new Point(j, i);
                    area[i][j] = 0;
                }
            }
        }

        BFS();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && area[i][j] == 1) {
                    sb.append(-1 + " ");
                } else {
                    sb.append(area[i][j] + " ");
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(target);
        visited[target.y][target.x] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int curX = p.x;
            int curY = p.y;
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if(!visited[nextY][nextX] && area[nextY][nextX] != 0) {
                        visited[nextY][nextX] = true;
                        q.add(new Point(nextX, nextY));
                        area[nextY][nextX] = area[curY][curX] + 1;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
