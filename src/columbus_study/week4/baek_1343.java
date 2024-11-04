package columbus_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1343 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder finalAnswer = new StringBuilder();
        int XCount = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'X') {
                XCount++;
            } else {
                if(XCount != 0) {
                    if(XCount % 2 != 0) {
                        System.out.println(-1);
                        return;
                    } else if (XCount % 4 == 0) {
                        for(int j = 0; j < XCount / 4; j++) {
                            finalAnswer.append("AAAA");
                        }
                    } else {
                        for(int j = 0; j < XCount / 4; j++) {
                            finalAnswer.append("AAAA");
                        }
                        finalAnswer.append("BB");
                    }
                }
                finalAnswer.append('.');
                XCount = 0;
            }
        }

        if(str.charAt(str.length()-1) == 'X') {
            if(XCount != 0) {
                if(XCount % 2 != 0) {
                    System.out.println(-1);
                    return;
                } else if (XCount % 4 == 0) {
                    for(int j = 0; j < XCount / 4; j++) {
                        finalAnswer.append("AAAA");
                    }
                } else {
                    for(int j = 0; j < XCount / 4; j++) {
                        finalAnswer.append("AAAA");
                    }
                    finalAnswer.append("BB");
                }
            }
        }

        System.out.println(finalAnswer.toString());
    }
}
