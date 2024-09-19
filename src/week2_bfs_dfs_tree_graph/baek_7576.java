package week2_bfs_dfs_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7576 {

    static int M, N;
    static int[][] area;
    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();
    static int days = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        area = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                area[i][j] = num;
                if(num == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        BFS();

    }

    public static void BFS() {

        //loop을 하루 치(level == 1) 돌면서 익은 토마토(1) 상하좌우에 있는 토마토가 0이면 1로 바꿔 주기
        while(!q.isEmpty()) {
            int[] idxes = q.poll();
            int x = idxes[1];
            int y = idxes[0];
            for(int i = 0; i < 4; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                if(nextX < M && nextX >= 0 && nextY < N && nextY >= 0) {
                    if(area[nextY][nextX] == 0) {
                        area[nextY][nextX] = area[y][x] + 1;
                        q.add(new int[]{nextY, nextX});
                    }
                }
            }

        }

        int max = Integer.MIN_VALUE;
        boolean allRipe = true;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(area[i][j] == 0) {
                    allRipe = false; // 익지 않은 토마토가 있다면 false로 변경
                }
                if(area[i][j] > max) {
                    max = area[i][j];
                }
            }
        }

        // 결과 출력
        if(!allRipe) {
            System.out.println(-1); // 모든 토마토가 익지 않은 경우
        } else {
            System.out.println(max - 1); // 첫날이 1로 시작했으므로 1일을 빼줌
        }

    }

}
