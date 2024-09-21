package week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_2667 {

    static int N;
    static int[][] area;
    static boolean[][] visited;
    static List<Integer> list;

    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                area[i][j] = line.charAt(j) - '0';
            }
        }

        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(area[i][j] == 1 && !visited[i][j]) {
                    int count = BFS(j, i);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list) {
            System.out.println(i);
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

    public static int BFS(int x, int y) {
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int curX = p.x;
            int curY = p.y;

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if(area[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                        q.add(new Point(nextX, nextY));
                        visited[nextY][nextX] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
