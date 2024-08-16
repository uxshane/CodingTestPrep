package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2840 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        char[] roulette = new char[N];
        Arrays.fill(roulette, '?');

        boolean[] alphabet = new boolean[26];  // 알파벳 중복 체크를 위한 배열 추가

        int K = Integer.parseInt(st.nextToken());
        int idx = 0;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int numOfRotate = Integer.parseInt(st.nextToken());
            char selectedAlphabet = st.nextToken().charAt(0);

            int changedIdx = idx - numOfRotate;
            if(changedIdx < 0) {
                idx = N + changedIdx;
            } else {
                idx = changedIdx;
            }

            if(roulette[idx] == selectedAlphabet) {
                continue;
            } else if(roulette[idx] == '?') {
                if (!alphabet[selectedAlphabet - 'A']) {  // 선택된 알파벳이 이미 사용되었는지 확인
                    roulette[idx] = selectedAlphabet;
                    alphabet[selectedAlphabet - 'A'] = true;  // 사용된 알파벳을 체크
                } else {
                    System.out.println("!");
                    return;
                }
            } else {
                System.out.println("!");
                return;
            }
        }

        int num = N;
        while(num-- > 0) {
            System.out.print(roulette[idx]);
            if(idx + 1 == N) {
                idx -= (N-1);
            } else {
                idx++;
            }
        }
    }
}
