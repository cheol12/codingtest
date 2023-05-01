package Main;

import java.io.*;
import java.util.*;

public class Main7662 {
    static int T;    // 테스트 횟수
    static int k;    // 테스트당 연산 횟수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tmap = new TreeMap<>();
            for(int j=0; j<k; j++){
                token = new StringTokenizer(br.readLine());
                String oper = token.nextToken();
                int data = Integer.parseInt(token.nextToken());

                if(oper.equals("D")){
                    if(tmap.isEmpty()) continue;
                    else if(data == 1){
                        // 트리맵에서 가장 큰 값 불러오기
                        int max = tmap.lastKey();
                        // 가장 큰 값의 밸류값(=개수) 가져오기
                        int cnt = tmap.get(max);

                        // 밸류=개수 1개면 삭제
                        if(cnt == 1) tmap.remove(max);
                            // 1개 이상이면 밸류=개수 값에서 하나 줄이기
                        else tmap.put(max, cnt-1);
                    }else if(data == -1){
                        int min = tmap.firstKey();
                        int cnt = tmap.get(min);

                        if(cnt == 1) tmap.remove(min);
                        else tmap.put(min, cnt -1);
                    }
                }else if(oper.equals("I")){
                    // data가 존재한다면 그의 밸류=개수 값을 가져오고
                    // 없으면 0을 가져온다.
                    // 그 다음 +1을 한 뒤 data 밸류=개수 값에 넣는다.
                    tmap.put(data, tmap.getOrDefault(data,0) + 1);
                }
            }
            // 1번의 테스트 진행 후 tmap이 아예 비어있으면 EMPTY출력
            if(tmap.isEmpty()) bw.write("EMPTY\n");
                // 비어있지 않다면 최대값, 최소값 같이 출력
            else bw.write(tmap.lastKey() + " " + tmap.firstKey() + "\n");
        }
        bw.close();
    }
}
//https://hello-backend.tistory.com/m/105