package Main;

import java.io.*;
import java.util.*;

class Main9466{
    static int T;   // 테스트 수
    static int n;   // 학생 수
    static int[] student;   // 학생 배열
    static int count;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            n = Integer.parseInt(br.readLine());
            student = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;
            token = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                student[j] = Integer.parseInt(token.nextToken());
            }

            for(int j=1; j<=n; j++){
                if(!finished[j])
                    dfs(j);
            }

            bw.write(n - count+"\n");
        }
        bw.close();
    }

    static void dfs(int selector){

        if(finished[selector]) return;
        if(visited[selector]){  // 한 팀의 구성원이다
            finished[selector] = true;
            count++;
        }
        visited[selector] = true;

        dfs(student[selector]);

        visited[selector] = false;  // 방문은 다시 초기화해서 다음 팀 구성에 지장이 없도록
        finished[selector] = true;  // 처음 학생인 selector 가 속한 팀 구성 완료
    }
}
//https://yeeybook.tistory.com/147