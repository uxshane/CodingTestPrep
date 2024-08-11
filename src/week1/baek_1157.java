package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();

        int[] chArr = new int[26];
        for(int i = 0; i < str.length(); i++) {
            chArr[str.charAt(i) - 'a']++;
        }

        // 26개의 int 배열을 돌면서 max랑 해당 idx를 뽑아 내야함.
        int max = 0;
        int idx = 0;
        for(int i = 0; i < chArr.length; i++) {
            if(chArr[i] > max) {
                max = chArr[i];
                idx = i;
            }
        }

        int count = 0;
        for(int i = 0; i < chArr.length; i++) {
            if(chArr[i] == max) {
                count++;
            }
        }

        System.out.println((count > 1 ? "?" : (char)( idx  + 'A')));
    }
}
