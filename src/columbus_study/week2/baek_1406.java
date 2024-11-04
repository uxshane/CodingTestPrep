package columbus_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class baek_1406 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for(int i = 0; i < input.length(); i++) {
            list.addLast(input.charAt(i));
        }

        ListIterator<Character> cursor = list.listIterator(list.size());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            switch (str.charAt(0)) {
                case 'L':
                    if(cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case 'D':
                    if(cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case 'B':
                    if(cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    char c = str.charAt(2);
                    cursor.add(c);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }

}
