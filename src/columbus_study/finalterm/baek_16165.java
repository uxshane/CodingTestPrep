package columbus_study.finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_16165 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> idolMap = new HashMap<>();
        List<String> idolList;
        for(int i = 0; i < N; i++) {
            String girlGroupName = br.readLine();
            idolList = new ArrayList<>();
            int num = Integer.parseInt(br.readLine());
            for(int j = 0; j < num; j++) {
                idolList.add(br.readLine());
            }
            idolMap.put(girlGroupName, idolList);
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            String question = br.readLine();
            int questionNumber = Integer.parseInt(br.readLine());
            if(questionNumber == 0) {
                List<String> groupMembers = idolMap.get(question);
                Collections.sort(groupMembers);
                for(String name : groupMembers) {
                    sb.append(name).append('\n');
                }
            } else {
                for(String groupName : idolMap.keySet()) {
                    if(idolMap.get(groupName).contains(question)) {
                        sb.append(groupName).append('\n');
                    }
                }
            }
        }

        System.out.println(sb);

    }


}
