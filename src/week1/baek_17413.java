package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_17413 {
    public static void main(String[] args) throws IOException {

//        알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
//                문자열의 시작과 끝은 공백이 아니다.
//        '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
//                태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
//                단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며,
//                태그와 단어 사이에는 공백이 없다.

        //조건 1: for문을 돌다가 '<'을 만나면 sb.append()하다가 '>'을 만나면 똑 떼어내서 다른 문자열에 저장 혹은 보관
        //조건 2: 단어끼리는 "공백"으로 구분된다 -> sb.append() 사용해서 공백을 만나면 sb를 다른 문자열에 저장 혹은 보관
        //조건 3: 태그 안에도 공백이 있을 수 있으니까 <>안에 있는 것들은 if문 안에서 continue로 밑에 거 스킵해주어야함.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        boolean isStillTag = false;
        for(int i = 0; i < input.length(); i++) {

            //태그일때
            if(input.charAt(i) == '<') {
                if(sb.length() != 0) {
                    list.add(sb.reverse().toString());
                    sb = new StringBuilder();
                }
                isStillTag = true;
                sb.append(input.charAt(i));
                continue;
            }
            //태그가 끝났을때
            if(isStillTag) {
                if(input.charAt(i) == '>') {
                    sb.append(input.charAt(i));
                    list.add(sb.toString());
                    sb = new StringBuilder();
                    isStillTag = false;
                    continue;
                }
                sb.append(input.charAt(i));
                continue;
            }

            //단어가 공백으로 구분될때
            if(input.charAt(i) == ' ') {
                list.add(sb.reverse().toString());
                sb = new StringBuilder();
            } else {
                sb.append(input.charAt(i));
                if(i == input.length()-1) {
                    list.add(sb.reverse().toString());
                }
            }

        }

        System.out.print(list.get(0));
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i - 1).contains("<")) {
                System.out.print(list.get(i));
            } else {
                if(list.get(i).contains("<")) {
                    System.out.print(list.get(i));
                } else {
                    System.out.print(" " + list.get(i));
                }
            }
        }
    }
}
