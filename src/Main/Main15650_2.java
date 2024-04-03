package Main;

import java.io.*;
import java.util.StringTokenizer;

public class Main15650_2 {
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[M+1];   // 길이가 M인 출력할 배열
        visited = new boolean[N+1];   // 중복 표시할 방문 배열

        // 인스턴스 1은 출력 배열 원소 중 1번째 원소를 정하는 것.
        dfs(1);
        bw.close();
    }

    static void dfs(int idx) throws IOException{

        // 리턴을 해야하는 탈출조건을 'idx가 M보다 크다면' 이라고 설정한 이유는
        // M개의 숫자가 모두 정해졌다는 뜻이기 때문에 이렇게 설정.
        // idx를 증가시키는 작업은 밑에서 실행.
        if(idx > M){
            for(int i=1; i<=M; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        // 1부터 N개의 숫자 중 출력할 숫자 정하는 반복문
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;    // 사용하지 않는 숫자인지 판단
            if(arr[idx - 1] >= i) continue; // 배열 오름차순 판단

            // 반복문 속 i를 배열 idx번째로 출력할 숫자로 결정.
            visited[i] = true;
            arr[idx] = i;
            dfs(idx + 1);
            visited[i] = false;
        }
    }
}
