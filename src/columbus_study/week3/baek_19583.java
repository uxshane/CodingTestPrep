package columbus_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;

public class baek_19583 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        LocalTime S = convertToTime(st.nextToken());
        LocalTime E = convertToTime(st.nextToken());
        LocalTime Q = convertToTime(st.nextToken());

        Set<String> beforeSet = new HashSet<>();
        Set<String> afterSet = new HashSet<>();

        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            LocalTime time = convertToTime(st.nextToken());
            String nickname = st.nextToken();
            if (time.isBefore(S) || time.equals(S)) {
                beforeSet.add(nickname);
            } else if (time.isBefore(Q) || time.equals(Q) && time.isAfter(E) || time.equals(E)) {
                if(beforeSet.contains(nickname)) {
                    afterSet.add(nickname);
                }
            }
        }

        System.out.println(afterSet.size());

    }
    public static LocalTime convertToTime(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
}
