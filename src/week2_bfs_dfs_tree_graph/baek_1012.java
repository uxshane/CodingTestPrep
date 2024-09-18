import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1012 {

    static int M, N, K, count;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            area = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                area[b][a] = 1;
            }

            count = 0;
            for(int y = 0; y < N; y++) {
                for(int x = 0; x < M; x++) {
                    if(area[y][x] == 1 && !visited[y][x]) {
                        count++;
                        DFS(y, x);
                    }
                }
            }

            System.out.println(count);

        }

    }

    public static void DFS(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                if(!visited[nextY][nextX] && area[nextY][nextX] == 1) {
                    DFS(nextY, nextX);
                }
            }
        }
    }
}
