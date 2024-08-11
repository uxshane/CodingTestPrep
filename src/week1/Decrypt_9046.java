package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decrypt_9046 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        oo: for(int i = 0; i < num; i++){
            int idx = 0;
            int max = 0;
            String str = br.readLine().replace(" ", "");
            int[] arr = new int[26];
            for(int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }

            for(int j = 0; j < arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    idx = j;
                }
            }

            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == max && j != idx) {
                    System.out.println("?");
                    continue oo;
                }
            }

           System.out.println((char)('a' + idx));
        }

    }
}
