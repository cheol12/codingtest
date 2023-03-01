package Main;

import java.io.*;
import java.util.*;

public class Main13305 {
    // 그리디 알고리즘
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());    // 도시 수
        long[] a = new long[N-1];     // 왼쪽부터 도시를 잇는 각 도로의 길이
        ArrayList<Long> b = new ArrayList<>();       // 각 도시에서의 리터당 가격

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            a[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            b.add(Long.parseLong(token.nextToken()));
        }
        b.remove(N-1);  // 마지막 도시에서의 리터당 가격은 필요없음.

        // 출발 시 반드시 다음 도시만큼 갈 수 있도록 주유해야한다.
        // 가장 리터당 가격이 적은 도시에서 최대한으로 주유해야한다.
        long sum = 0;    // 총 비용
        for(int i=0; i<N-1; i++){
            // a[i] = 다음 도시까지 거리, b.get(i) = 현재 리터당 가격
            sum += a[i] * b.get(i);
            if(b.get(i) == Collections.min(b)){
                for(int j=i+1; j<N-1; j++){
                    sum += a[j] * b.get(i);
                }
                break;
            }
        }
        bw.write(String.valueOf((long)sum));
        bw.close();
    }

}

