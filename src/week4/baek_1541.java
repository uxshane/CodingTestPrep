package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] splittedByMinus = str.split("-");
        int[] finalNumbers = new int[splittedByMinus.length];

        for(int i = 0; i < splittedByMinus.length; i++) {
            int num = 0;
            String[] splittedByPlus = splittedByMinus[i].split("\\+");
            for(int j = 0; j < splittedByPlus.length; j++) {
                num += Integer.parseInt(splittedByPlus[j]);
            }
            finalNumbers[i] = num;
        }

        int finalNum = finalNumbers[0];
        for(int i = 1; i < finalNumbers.length; i++) {
            finalNum -= finalNumbers[i];
        }

        System.out.println(finalNum);
    }
}
