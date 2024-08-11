package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_3613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        if(input.contains("_")
                && input.charAt(0) != '_'
                && input.charAt(input.length()-1) != '_'
                && Character.isLowerCase(input.charAt(0))) {
            for(int i = 0; i < input.length(); i++) {
                if(i == 0) {
                    sb.append(input.charAt(i));
                    continue;
                }
                if(input.charAt(i - 1) == '_') { //바로 이전 문자가 '_'인 경우
                    if(Character.isUpperCase(input.charAt(i))) {
                        System.out.println("Error!");
                        return;
                    }
                    sb.append(Character.toUpperCase(input.charAt(i)));
                    if(input.charAt(i) == '_') {
                        System.out.println("Error!");
                        return;
                    }
                } else { //바로 이전 문자가 '_'이 아닌 경우
                    if(input.charAt(i) == '_') {
                        continue;
                    }
                    if(Character.isUpperCase(input.charAt(i))) {
                        System.out.println("Error!");
                        return;
                    }
                    sb.append(input.charAt(i));
                }
            }
        } else if (Character.isLowerCase(input.charAt(0)) && !input.contains("_")) {
            for(int i = 0; i < input.length(); i++) {
                if(i == 0) {
                    sb.append(input.charAt(i));
                    continue;
                }
                if(Character.isUpperCase(input.charAt(i))) {
                    sb.append("_" + Character.toLowerCase(input.charAt(i)));
                } else {
                    sb.append(input.charAt(i));
                }
            }
        } else {
            System.out.println("Error!");
        }

        System.out.println(sb.toString());
    }
}
