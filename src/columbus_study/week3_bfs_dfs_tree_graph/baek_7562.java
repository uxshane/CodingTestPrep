package columbus_study.week3_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7562 {

    static int I;
    static Point start;
    static Point target;
    static int[][] area;
    static boolean[][] visited;
    static int[] dirX = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dirY = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());

            area = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            target = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            BFS();

            sb.append(area[target.y][target.x]).append("\n");
        }
        System.out.println(sb);

    }

    private static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            for(int i = 0; i < 8; i++) {
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];

                if(nextX < I && nextY < I && nextX >= 0 && nextY >= 0) {
                    if(!visited[nextY][nextX]) {
                        q.add(new Point(nextX, nextY));
                        area[nextY][nextX] = area[curY][curX] + 1;
                        visited[nextY][nextX] = true;
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
