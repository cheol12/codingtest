package Main;

import java.io.*;
import java.util.*;

public class Main1414 {
    // 그래프 이론
    // 문자열
    // 최소 스패닝 트리

    static int[] parent;    // 부모 노드
    static int N,sum;           // 입력할 컴퓨터 개수, 랜선 길이 총합
    static PriorityQueue<pEdge> queue;
    // 랜선 정보 저장할 우선순위 큐

    public static void main(String args[]) throws IOException{
        //최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는
        //부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
        //
        //입력 : 첫째 줄에 컴퓨터의 개수 N이 주어진다. 둘째 줄부터 랜선의 길이가
        // 주어진다. i번째 줄의 j번째 문자가 0인 경우는 컴퓨터 i와 컴퓨터 j를
        // 연결하는 랜선이 없음을 의미한다. 그 외의 경우는 랜선의 길이를 의미한다.
        // 랜선의 길이는 a부터 z는 1부터 26을 나타내고, A부터 Z는 27부터 52를
        // 나타낸다. N은 50보다 작거나 같은 자연수이다.
        //
        //출력 : 첫째 줄에 다솜이가 기부할 수 있는 랜선의 길이의 최댓값을 출력.
        // 만약, 모든 컴퓨터가 연결되어 있지 않으면 -1을 출력.

        // 최소 신장 트리 세팅
        // -> 1. 에지 리스트로 그래프 구현, 유니온 파인드 리스트 초기화
        // -> 유니온 파인드는 사이클 판별을 위해 사용.
        // -> 2. 에지 리스트 그래프 데이터를 가중치 기준으로 오름차순 정렬
        // -> 3. 가중치가 낮은 에지부터 연결 시도하기
        // -> 3번 과정 중에서 find 연산으로 사이클 유무 판단 후,
        // -> 사이클이 없을 때만 union 연산으로 두 노드 연결.
        // -> 4. 전체 노드 개수가 N일 때, 에지 개수가 N-1될 때까지 3번 계속 반복.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();

        // 간선=랜선이 연결하는 컴퓨터 i, j와 가중치를 표현하여 우선순위 큐에 저장.
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            // 입력한 알파벳들을
            char[] tempc = token.nextToken().toCharArray(); // 한 글자마다 나누기 위한 배열
            for(int j=0; j<N; j++){
                int temp = 0;   // 간선=랜선 하나만 저장할 임의 객체
                if(tempc[j] >= 'a' && tempc[j] <= 'z')  // a~z 사이의 값이면
                    // 만약, tempc[j] = a 이고 유니코드 상에서 'a'만큼 빼고 1을 더하면
                    // tempc[j] = a = 1 이 된다. => a~z = 1~26
                    temp = tempc[j] - 'a' + 1;
                else if(tempc[j] >= 'A' && tempc[j] <= 'Z') // A~Z 사이의 값이면
                    temp = tempc[j] - 'A' + 27;

                sum = sum + temp;   // 모든 랜선 길이 합에 해당 랜선을 추가
                // 컴퓨터가 다르고 간선=랜선이 0이 아니면 우선순위큐 객체인 queue에 추가
                if(i != j && temp != 0) queue.add(new pEdge(i,j,temp));
            }
        }

        parent = new int[N];    // 해당 노드의 부모 노드 표현할 배열

        for(int i=0; i<parent.length; i++){
            parent[i] = i;  // 처음엔 자신으로 초기화
        }
        int useEdge = 0;    // 기부할 랜선의 개수
        int result = 0;     // 기부할 랜선 길이의 최댓값 = 사이클이 없을 때의 가중치 합

        while(!queue.isEmpty()){    // queue가 빌 때까지 최소 신장 트리 알고리즘 수행
            // 오름차순으로 정렬된 queue에서 낮은 수부터 꺼낸 뒤
            // 그 수를 pEdge 객체인 now로 설정
            pEdge now = queue.poll();
            // pEdge 객체인 now에서 s와 e의 부모노드가 다르면 연결
            // find로 각자 부모 노드 확인 -> union으로 연결.
            if(find(now.s) != find(now.e)){
                union(now.s,now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        // result의 합은 결국 다솜이가 원하는
        // 집 안에 컴퓨터들이 모두 연결 가능한 랜선 길이의 최솟값이 됨.

        // 다솜이가 기부할 수 있는 랜선 길이의 최댓값
        // = 입력으로 주어진 랜선 총합(sum) - 최소 신장 트리 결과(result)

        // 에지=간선=랜선의 개수가 N-1일 때만 최소 신장 트리. 이때, 간선의 가중치를 구한다.
        if(useEdge == N-1) bw.write(String.valueOf(sum - result));

        // 컴퓨터 모두가 연결 되어 있지 않으므로 -1 출력
        else bw.write("-1");

        bw.close();
    }

    // find 연산 : a의 대표노드를 찾는 연산.
    static int find(int a){
        if(a == parent[a]) return a;    // 본함수 : 최상위 노드가 자신일 때 자신을 리턴하며 멈추기.
        else return parent[a] = find(parent[a]);    // 재귀(본함수 결과에 맞게 나올 때까지 반복)
    }
    // union 연산 : a,b의 각 대표 노드가 다르다면 x,y를 연결하는 연산
    static void union(int a, int b){    // union 연산 : 대표 노드끼리 연결하는 연산
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
        // a와 b의 대표 노드가 다를 때만 a와 b를 연결
        // a와 b의 대표 노드가 같다면 사이클이 만들어져서 가중치의 합이 최소가 될 수 없다.
    }
}

// 시작점s, 끝점e, 가중치v 를 표현하는 클래스 pEdge를 생성하고
// 가중치 기준으로 오름차순 정렬한다.
class pEdge implements Comparable<pEdge>{
    int s;
    int e;
    int v;
    pEdge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }
    // 우선순위 큐에서 우선순위가 되는 조건 = 가중치 오름차순 정렬
    @Override
    public int compareTo(pEdge o){
        return this.v - o.v;
    }
    //현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
    //현재 객체 == 파라미터로 넘어온 객체: 0 리턴
    //현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
    //음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
    //큐 특성 = 선입선출,
    //문제에서 오름차순 정렬 기준으로 큐에 입력해야한다.

    //현재 객체보다 새로 들어온 파라미터 객체가 더 작다면,
    //서로 자리를 바꿔서 파라미터가 더 빨리 출력되게끔 한다.
    //큐의 선입선출 특성상 현재 객체가 더 빨리 출력되어야 하지만,
    //오름차순 정렬 조건이 추가된 우선순위 큐이기 때문에
    //현재보다 더 작은 파라미터가 더 빨리 출력되어야 함.
}