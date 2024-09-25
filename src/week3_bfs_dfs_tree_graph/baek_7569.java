package week3_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7569 {

    static int M, N, H;
    static int[][][] area;
    static boolean[][][] visited;

    static int[] dirM = {0, 1, 0, -1, 0, 0};
    static int[] dirN = {1, 0, -1, 0, 0, 0};
    static int[] dirH = {0, 0, 0, 0, 1, -1};

    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        area = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    area[i][j][k] = Integer.parseInt(st.nextToken());
                    if(area[i][j][k] == 1) {
                        q.add(new Point(k, j, i));
                    }
                    if(area[i][j][k] == -1) {
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        System.out.println(BFS());

    }

    static class Point{
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int BFS() {

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            visited[z][y][x] = true;
            for(int i = 0; i < 6; i++) {
                int nextX = x + dirM[i];
                int nextY = y + dirN[i];
                int nextZ = z + dirH[i];
                if(rangeCheck(nextX, nextY, nextZ) && !visited[nextZ][nextY][nextX] && area[nextZ][nextY][nextX] == 0) {
                    visited[nextZ][nextY][nextX] = true; // 큐에 추가할 때 방문 처리
                    area[nextZ][nextY][nextX] = area[z][y][x] + 1;
                    q.add(new Point(nextX, nextY, nextZ));
                }

            }
        }

        int maxday = Integer.MIN_VALUE;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(area[i][j][k] == 0) {
                        return -1; // 익지 않은 토마토가 있으면 바로 -1 반환
                    }
                    maxday = Math.max(maxday, area[i][j][k]);
                }
            }
        }


        return maxday-1;
    }

    static boolean rangeCheck(int nextX, int nextY, int nextZ) {
        if(nextX >= M || nextY >= N || nextZ >= H) {
            return false;
        }
        if(nextX < 0 || nextY < 0 || nextZ < 0) {
            return false;
        }
        return true;
    }

}
