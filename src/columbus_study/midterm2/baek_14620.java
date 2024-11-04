package columbus_study.midterm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14620 {

    static int N;
    static int cost = Integer.MAX_VALUE;
    static int[][] area;
    static boolean[][] visited;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);
        System.out.println(cost);

    }

    static int getCost(int x, int y) {
        int c = 0;
        c += area[y][x];

        for(int i = 0; i < 4; i++) {
            c += area[y + dirY[i]][x + dirX[i]];
        }

        return c;
    }

    static boolean checkRange(int x, int y) {
        for(int i = 0; i < 4; i++) {
            if(x + dirX[i] >= N || y + dirY[i] >= N || x + dirX[i] < 0 || y + dirY[i] < 0 || visited[y+dirY[i]][x+dirX[i]]) {
                return false;
            }
        }
        return true;
    }

    static void placeSeed(int x, int y) {
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            visited[y + dirY[i]][x + dirX[i]] = true;
        }
    }

    static void removeSeed(int x, int y) {
        visited[y][x] = false;
        for(int i = 0; i < 4; i++) {
            visited[y + dirY[i]][x + dirX[i]] = false;
        }
    }

    static void DFS(int level, int addUpCost) {

        if(level == 3) {
            //꽃이 3개가 피었으니 cost구하기
            if(addUpCost <= cost) {
                cost = addUpCost;
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                //만약 seed를 놓을 곳이 1) range 범위 안이거나, 2) 방문되지 않은 곳이면
                if(checkRange(j, i)) {
                    placeSeed(j, i);
                    //level + 1로 하고, addUpCost도 더해주고 나머지 seed 위치 계속 구하기
                    DFS(level + 1, addUpCost + getCost(j, i));
                    //다 구하면 맨 마지막에 놨던 seed 빼고 이어서 가기
                    removeSeed(j, i);
                }

            }
        }

    }

}
