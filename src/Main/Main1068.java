package Main;

import java.io.*;
import java.util.*;

public class Main1068 {
    //그래프 이론
    //그래프 탐색
    //트리
    //깊이 우선 탐색

    static int N;               // 노드 개수
    static int[] parents;       // 부모노드
    static int count = 0;       // 자식 없는 노드 개수
    static int delete;          // 삭제할 노드
    static boolean[] visited;       // 방문한 노드

    public static void main(String args[]) throws IOException{
        // 트리에서 리프 노드란, 자식의 개수가 0인 노드를 말한다.
        // 트리가 주어졌을 때, 노드 하나를 지울 것이다. 그 때, 남은 트리에서
        // 리프 노드의 개수를 구하는 프로그램을 작성하시오. 노드를 지우면
        // 그 노드와 노드의 모든 자손이 트리에서 제거된다.

        // N을 입력 -> 노드는 N만큼 존재하게 됨.
        // -> 각 i번째 노드의 부모를 입력한다. 부모 없다면 -1로 입력
        // -> 마지막에 지울 노드 입력.
        // 노드 입력 시 for(int i=0; i<N; i++) 안에 parents 값 입력
        //
        // 비어있으면 제거한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());    // 노드 개수
        parents = new int[N];   // parents[i] 는 i의 부모를 표현
        int root = 0;   // 최상위 노드 = 루트 노드의 초기값(아직 지정되지 않은 초기값)

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            parents[i] = Integer.parseInt(token.nextToken());
            if(parents[i] == -1) root = i;  // 루트 노드를 뜻함.
        }
        delete = Integer.parseInt(br.readLine());   // 삭제할 노드

        func_delete(delete);

        count = 0;  // 자식 없는 노드 개수
        visited = new boolean[N];   // 방문 확인 배열
        boolean[] visited2 = new boolean[N];
        countLeaf(root);    // 괄호 안 객체를 방문하며 리프 노드인지 판단 후 count 증가시키는 함수

        bw.write(Arrays.toString(parents)+"\n");
        bw.write(Arrays.toString(visited2)+"\n");
        bw.write(String.valueOf(count)+"\n");
        bw.close();
    }

    // 재귀함수 구성 : 실제 진행문 구현, 반복문 안에서 다시 본함수 실행.
    static void func_delete(int d){ // delete=d 노드를 삭제한 것을 확인하는 메소드
        // 삭제된 노드를 임의로 -2로 표시, 진행 과정에서 아예 영향이 없는 숫자로 설정하여 삭제한 것으로 취급.
        parents[d] = -2;    // 4를 삭제했으므로 4의 부모를 가리키는 parents[4] 또한 찾을 수 없다.
        for(int i=0; i<N; i++){
            if(parents[i] == d){    // delete=d=4 값을 부모로 가지고 있는 노드 i(5-6)가 있다면 노드 i(5-6) 삭제하기.
                func_delete(i); // 해당 i를 부모로 갖고 있는 것을 기준으로 다시 재귀함수
            }
        }
    }
    // 삭제 순서 : 4 - 5 - 6 - 7 - 8,
    // delete로 입력한 4삭제(=-2로 갱신) -> 4를 부모로 둔 5삭제 -> 5를 부모로 둔 노드 반복문에서 탐색
    // -> 5를 부모로 둔 노드 6,7,8 중에 없음. -> '4를 부모로 둔 5삭제' 시점까지 빠져나옴.
    // -> 4를 부모로 둔 노드 마저 검색 -> 4를 부모로 둔 6삭제
    // -> 6을 부모로 둔 7삭제 -> 7을 부모로 둔 것 없음. -> 6을 부모로 둔 8삭제
    // -> 8은 마지막이므로 부모 어차피 없음. -> 6 탐색 끝 -> '4를 부모로 둔 6삭제' 시점부터 마저 검색
    // -> 4를 부모로 둔 것 나머지(7,8) 다 없음 -> 4 탐색 끝 -> 재귀 모두 종료.

    static void countLeaf(int c){
        boolean isLeaf = true;  // 리프노드에게 true값을 전달할 객체
        visited[c] = true;  // 노드c 방문한 것으로 취급
        if(parents[c] != -2){   // c가 삭제된 노드가 아니라면

            // c를 부모로 하는 자식이 있는지 판단하는 반복문 실행
            for(int i=0; i<N; i++){
                // 해당 c를 부모로 하는 노드 i가 존재하고 + 노드 i를 방문하지 않았다면
                if(parents[i] == c && visited[i] == false) {
                    countLeaf(i);   // i를 방문하고 i를 부모로 하는 노드를 찾기 방문 (재귀)
                    isLeaf = false; // c는 자식이 있으므로 리프 노드가 아님.
                }
            }
            // 재귀 함수 돌 때마다 처음 노드부터 다시 반복하기 때문에 다시 방문한 것은 건너뛰어야 한다.
            // 그러므로 if 조건문에 '&& visited[i] == false' 조건 추가.

            if(isLeaf) count++; // c를 부모로 하는 노드가 없으면 c는 리프 노드이다.
        }
    }
}
// https://moonsbeen.tistory.com/229

//9
//-1 0 0 2 2 4 4 6 6
//4



