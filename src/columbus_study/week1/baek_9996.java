package columbus_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_9996 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //개수
        int num = Integer.parseInt(br.readLine());
        //패턴
        String pattern = br.readLine();
        String[] split_pt = pattern.split("\\*");

        for(int i = 0; i < num; i++) {
            String str = br.readLine();
            if (str.length() < split_pt[0].length() + split_pt[1].length()) {
                System.out.println("NE");
                continue;
            }

            String f_str = str.substring(0, split_pt[0].length());
            String b_str = str.substring(str.length() - split_pt[1].length());
            if(split_pt[0].equals(f_str) && split_pt[1].equals(b_str)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

    }
}
