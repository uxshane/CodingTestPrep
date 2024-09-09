package finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17276 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            d = d < 0 ? d = (d + 360) / 45 : d / 45;

            int[][] twoDArray = new int[n][n];
            int[][] copyArray = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    twoDArray[i][j] = Integer.parseInt(st.nextToken());
                    copyArray[i][j] = twoDArray[i][j];
                }
            }

            while(d-- > 0) {
                for(int i = 0; i < n; i++) {
                    copyArray[i][n/2] = twoDArray[i][i];
                    copyArray[i][i] = twoDArray[n/2][i];
                    copyArray[n/2][i] = twoDArray[n-i-1][i];
                    copyArray[n-i-1][i] = twoDArray[n-i-1][n/2];
                }

                for (int i = 0; i < n; i++) {
                    twoDArray[i] = Arrays.copyOf(copyArray[i], n);
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sb.append(twoDArray[i][j]).append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);

    }
}
