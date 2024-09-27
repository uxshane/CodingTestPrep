package week3_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_16234 {

    static int N, L, R;
    static int[][] area;
    static boolean[][] visited;
    static List<Point> countries;

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    static boolean ifAnyMoved;
    static int days;

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
        area = new int[N][N];

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(doAllImmigrated());

    }

    static int doAllImmigrated() {
        days = 0;
        while(true) {
            visited = new boolean[N][N];
            ifAnyMoved = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        BFS(j, i);
                    }
                }
            }

            if(!ifAnyMoved) {
                return days;
            }
            days++;
        }
    }

    static void BFS(int x, int y) {
        countries = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while(!q.isEmpty()) {
            Point p = q.poll();
            int curX = p.x;
            int curY = p.y;

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                if(nextX < N && nextX >= 0 && nextY < N && nextY >= 0) {
                    int diff = Math.abs(area[curY][curX] - area[nextY][nextX]);
                    if(!visited[nextY][nextX] && diff >= L && diff <= R) {
                        visited[nextY][nextX] = true;
                        q.add(new Point(nextX, nextY));
                        countries.add(new Point(nextX, nextY));
                        ifAnyMoved = true;
                    }
                }
            }
        }

        if(!countries.isEmpty()) {
            immgrate();
        }
    }

    static void immgrate() {
        int sum = 0;
        for(Point p : countries) {
            sum += area[p.y][p.x];
        }

        int avg = sum / countries.size();
        for(Point p : countries) {
            area[p.y][p.x] = avg;
        }
    }

}
