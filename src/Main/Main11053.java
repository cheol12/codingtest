package Main;

import java.util.*;
import java.io.*;

class Main11053{
    static int N;
    static int[] A,suyeol;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        suyeol = new int[N+1];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(token.nextToken());
        }

        suyeol[1] = 1;
        for(int i=2; i<=N; i++){
            // 어디부터 생각하든 부분 수열 개수는 하나(그 하나에 해당하는 것 = A[i]),
            // suyeol[i]=1로 하는 이유 : ex) {30,40,50,10,20} 같은 경우에서
            // A[4]까지의 부분 수열 개수를 1개로 인식할 수 있다.
            // 따라서 아래 반복문은 A[i] 이전에 A[i]보다 작은 오름차순 배열 속
            // 숫자가 몇 개인지 찾는 과정이라 생각
            suyeol[i] = 1;
            // suyeol[i] = A[1]~A[i]까지 오름차순인 부분 수열 개수
            for(int j=1; j<i; j++){
                if(A[i] > A[j])     // A[i]가 이전 값(=j)보다 크면
                    // 부분 수열[i]의 개수는 이전 부분 수열보다[j] 반드시 크다.
                    suyeol[i] = Math.max(suyeol[i], suyeol[j]+1);
            }
        }
        Arrays.sort(suyeol);
        bw.write(String.valueOf(suyeol[N]));
        bw.close();
    }
}
//https://propercoding.tistory.com/41
// 최장 증가 부분 수열 LIS