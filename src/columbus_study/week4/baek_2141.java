package columbus_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2141 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        House[] houses = new House[N];
        long totalPopulation = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            long population = Integer.parseInt(st.nextToken());
            houses[i] = new House(position, population);
            totalPopulation += population;
        }

        Arrays.sort(houses);
        long population = 0;

        for(int i = 0; i < N; i++) {
            population += houses[i].population;
            if((totalPopulation + 1) / 2 <= population) {
                System.out.println(houses[i].location);
                break;
            }
        }
    }

    static class House implements Comparable<House> {
        int location;
        long population;

        public House(int location, long population) {
            this.location = location;
            this.population = population;
        }

        @Override
        public int compareTo(House o) {
            return Integer.compare(this.location, o.location);
        }
    }
}
