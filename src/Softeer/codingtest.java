package Softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// N은 연료탱크 개수, M은 최소 필요 연료량.
// 연료탱크 사용 도중 M을 넘어가면 사용하던 연료탱크의 잔여량은 폐기된다.
// 주어진 연료탱크 중 최대 3개까지 사용하여 만들 수 있는 M 이상인 최소의 연료량을 출력하라.
// 조합이 불가능한 경우 IMPOSSIBLE 출력.

public class codingtest {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtoken;

        strtoken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(strtoken.nextToken());
        int M = Integer.parseInt(strtoken.nextToken());

        // 연료탱크들을 원소로 한 배열
        ArrayList<Integer> aa = new ArrayList<Integer>();

        strtoken = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            aa.add(Integer.parseInt(strtoken.nextToken()));
        }

        // M보다 큰 연료탱크의 합 -> 들의 경우의 수
        ArrayList<Integer> aasum = new ArrayList<Integer>();

        for(int a=1; a<=3; a++){    // a = 선택 연료탱크 개수
            if(a==1){
                for(int b=0; b<N; b++){
                    // M보다 크고 and aasum에 없으면 넣어라(중복제거)
                    if(aa.get(b) >= M && !aasum.contains(aa.get(b)))
                        aasum.add(aa.get(b));
                }
            }else if(a==2){
                for(int b=0; b<N-1; b++){
                    for(int c=b+1; c<N; c++){
                        int sum = aa.get(b) + aa.get(c);

                        // M보다 크고 and 계산한 sum이 aasum에 없으면 넣어라(중복제거)
                        if(sum >= M && !aasum.contains(sum))
                            aasum.add(sum);
                    }
                }

            }else if(a==3){
                for(int b=0; b<N-2; b++){
                    for(int c=b+1; c<N-1; c++){
                        for(int d=c+1; d<N; d++){
                            int sum = aa.get(b) + aa.get(c) + aa.get(d);

                            // M보다 크고 and 계산한 sum이 aasum에 없으면 넣어라(중복제거)
                            if(sum >= M && !aasum.contains(sum))
                                aasum.add(sum);
                        }
                    }
                }
            }
        }

        if(aasum.size() == 0) {
//            System.out.println("IMPOSSIBLE");
            bw.write("IMPOSSIBLE");
        }
        else{
            int result = Collections.min(aasum);
//            System.out.println(aasum + "\n" + result);
            bw.write("result:"+result);
        }
        bw.close();
//        테스트 입력
//        5 100
//        40 90 20 15 15
    }
}
