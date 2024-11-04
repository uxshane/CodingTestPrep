package columbus_study.week3_bfs_dfs_tree_graph;

import java.util.Scanner;

public class baek_22857 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int oddCount = 0;
        int maxLength = 0;

        while(right < N) {
            if(arr[right] % 2 != 0) {
                oddCount++;
            }

            while(oddCount > K) {
                if(arr[left] % 2 != 0) {
                    oddCount--;
                }
            }

        }

    }
}
