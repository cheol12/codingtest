package Main;

import java.util.*;
import java.io.*;

public class Main15649 {
    static int N,M;
    static boolean[] visited;
    static int[] a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());    // 자연수 N개
        M = Integer.parseInt(token.nextToken());    // N개 중 뽑을 M개

        //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

        visited = new boolean[N+1]; // 1~N 자연수 출력 여부 확인 배열
        a = new int[M+1];           // M개만큼 뽑아서 출력할 배열

        DFS(0);    // a[0]부터 출력하기 위해 DFS(0) 실행

        bw.close();
    }
    static void DFS(int x) throws IOException{
        // DFS를 통해 출력할 M개가 정해질 때마다 출력한다.
        // = 동시에 하나의 DFS가 빠져나오는 조건
        if(x == M){
            for(int i=0; i<M; i++){ // M개만큼 출력해야함
                bw.write(a[i] + " ");
            }
            bw.write("\n");
            return;                 // 해당 DFS 빠져나오기
        }
        for(int i=1; i<=N; i++){    // 숫자 확인 후 a[i]에 위치시키는 DFS 연산
            if(!visited[i]){        // 자연수 i가 출력에 쓰이지 않았다면
                visited[i] = true;  // 출력하기로 한다.
                a[x] = i;           // a[x], x번째 출력을 i로 한다.
                //x += 1;           // 여기서 x+1을 하면 다음 DFS에서 빠져나올 때 증가된 채로 돌아와서 다음 반복문에 차질 생김.
                DFS(x+1);           // 다음(=x+1번째) 출력값 구하기 위해 DFS(x+1)를 수행

                // 다음 DFS에서 이전DFS로 빠져나올 때, i를 출력 안하는 것으로 다시 갱신
                visited[i] = false;

                // 이후로 계속 반복문 진행하며 출력할 수 있는 다른 수열 탐색
            }
        }
    }
}
//https://www.youtube.com/watch?v=Enz2csssTCs
//https://iseunghan.tistory.com/229