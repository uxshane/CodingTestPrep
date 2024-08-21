package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class baek_1620 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> keyMap = new HashMap<>();
        HashMap<String, Integer> valueMap = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String input = br.readLine();
            keyMap.put(i, input);
            valueMap.put(input, i);
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            String input = br.readLine();
            if(isInteger(input)) {
                sb.append(keyMap.get(Integer.parseInt(input))).append('\n');
            } else {
                sb.append(valueMap.get(input)).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
