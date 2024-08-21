package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class baek_4358 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        String input;
        int total = 0;
        while((input = br.readLine()) != null && input.length() != 0) {
            total++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = String.format("%.4f", (double) entry.getValue()*100 / (double) total);
            sb.append(entry.getKey() + " " + str).append('\n');
        }

        System.out.println(sb.toString());
    }
}
