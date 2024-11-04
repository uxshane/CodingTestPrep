package columbus_study.finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class programmers_72410 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        //프로그래머스용
        //String input = new_id.toLowerCase();

        //2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        input = input.replaceAll("[^-_.a-z0-9]", "");

        //3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        while(input.contains("..")) {
            input = input.replace("..", ".");
        }

        //4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
        if(input.length() != 0) {
            if (input.charAt(0) == '.') {
                input = input.substring(1, input.length());
            }
        }

        if(input.length() != 0) {
            if(input.charAt(input.length() - 1) == '.') {
                input = input.substring(0, input.length()-1);
            }
        }

        //5단계: 빈 문자열이라면, new_id에 "a"를 대입
        if(input.length() == 0) {
            input = "a";
        }

        //6단계: 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        if(input.length() >= 16) {
            input = input.substring(0, 15);
            if(input.charAt(input.length() - 1) == '.') {
                input = input.substring(0, input.length() - 1);
            }
        }

        //7단계: 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        if(input.length() <= 2) {
            char c = input.charAt(input.length() - 1);
            while(input.length() < 3) {
                input += c;
            }
        }

        System.out.println(input);
    }
}
