package columbus_study.midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class baek_2870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> numList = new ArrayList<>();

        while(N-- > 0) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length();) {
                int count = 0;
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                    count++;
                    for(int j = i+1; j < str.length(); j++) {
                        if(str.charAt(j) < '0' || str.charAt(j) > '9') {
                            break;
                        }
                        sb.append(str.charAt(j));
                        count++;
                    }
                    numList.add(new BigInteger(sb.toString()));
                    sb = new StringBuilder();
                    i+=count;
                } else {
                    i++;
                }
            }
        }

        numList.sort(Comparator.naturalOrder());

        for(BigInteger n : numList) {
            System.out.println(n);
        }


    }
}
