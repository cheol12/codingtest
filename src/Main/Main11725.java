package Main;

import java.io.*;
import java.util.*;

//그래프 이론
//그래프 탐색
//트리
//너비 우선 탐색
//깊이 우선 탐색

public class Main11725 {
    static int[] parents;       // 부모노드

    // 1. 부모 찾기이므로 부모 노드를 나타낼 부모 배열 객체 parents[] 생성

    // 2. 노드 1 ~ N 에 해당하는 각각의 노드와 그와 연결된 노드들을 표시하기 위해서
    // ArrayList 형태로 저장한다.
    // 이로써 ArrayList로 구성된 [N+1] 크기의 배열 객체를 생성하는 것이 적합하다고
    // 판단한다.
    // => ArrayList<Integer>[] a = new ArrayList[N+1];
    // 1 ~ N+1 까지 각 배열을 초기화 함과 동시에 생성한다.
    // a [i] = new ArrayList<>();

    // 3. Queue 객체에 초기 부모노드로 설정된 값을 poll() 하며 parents[i]에 i의 부모노드를 입력.
    // 해당 i를 다음 부모노드로 설정하며 반복문 진행
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());

        // 리스트로 구성된 배열
        ArrayList<Integer>[] a = new ArrayList[N+1];    // 각 a[i]가 하나의 리스트 객체가 됨.
        parents = new int[N + 1];   // parents[0] ~ parents[7]

        // 각 리스트 객체인 a[i]를 생성
        for(int i=1; i<=N; i++){
            a[i] = new ArrayList<>();   // 각 a[i]를 초기화 = 비어있는 값들이 들어감.
        }

        for(int i=1; i<N; i++){
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            // 양방향으로 추가.
            a[x].add(y);
            a[y].add(x);
        }

        // 부모 찾는 큐
        Queue<Integer> q = new LinkedList<>();

        q.add(1);   // 처음 루트 노드 설정. = 현재 부모 노드 설정.

        // 디버깅 중에 while문 무시하던데 이유를 모르겠음..
        while(!q.isEmpty()){    // 큐가 비게 되면 멈추기.
            int now = q.poll(); // 현재 부모 노드 설정. = 초기값은 1

            for(int child : a[now]){    // 모든 a[1] 안 원소에 대해 반복문 실행.

                if(parents[child] != 0){    // child의 부모노드가 있으면 생략하고 다음 반복문.
                     continue;
                }

                // child의 부모노드가 없으면 now를 설정.
                // a[1] 에는 4,6이 있음.
                // i의 부모를 나타내는 parents[i]에서
                // parents[4]와 parents[6]에 now(=1) 삽입.
                // 4와 6의 부모는 1이라는 뜻이 됨.
                parents[child] = now;

                // child = 4 를 다음 부모 노드로 설정하고 다시 반복문 실행.
                q.add(child);
            }
        }
        for(int i=2; i<=N; i++){
            bw.write(String.valueOf(parents[i])+"\n");
        }
        bw.close();
    }
}
