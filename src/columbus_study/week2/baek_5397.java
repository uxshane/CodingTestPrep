package columbus_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class baek_5397 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb;
        LinkedList<Character> list;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            list = new LinkedList<>();
            ListIterator<Character> itr = list.listIterator();
            for (int j = 0; j < input.length(); j++) {
                switch (input.charAt(j)) {
                    case '<':
                        if (itr.hasPrevious()) {
                            itr.previous();
                        }
                        break;
                    case '>':
                        if (itr.hasNext()) {
                            itr.next();
                        }
                        break;
                    case '-':
                        if (itr.hasPrevious()) {
                            itr.previous();
                            itr.remove();
                        }
                        break;
                    default:
                        itr.add(input.charAt(j));
                        break;
                }
            }
            sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

    }
}
