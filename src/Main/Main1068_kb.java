package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1068_kb {
    static int N, root;
    static ArrayList<Integer>[] arrList;
    static int[] parents;
    static int remove, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        arrList = new ArrayList[N+1];
        parents = new int[N+1];

        for(int i=0; i<N; i++)
            arrList[i] = new ArrayList<>();

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            parents[i] = Integer.parseInt(token.nextToken());
            if(parents[i] != -1) arrList[parents[i]].add(i);
            else root = i;
        }

        remove = Integer.parseInt(br.readLine());

        // arrList[i].remove(remove);
        // -> 이는 remove인덱스에 위치한 원소를 제거하는 것이다
        // 값 자체가 remove인 원소를 제거하려면
        // Integer.valueOf()로 감싸서 Object 객체로 만들어서 써야한다.
        for(int i=0; i<N; i++){
            arrList[i].remove(Integer.valueOf(remove));
        }

        DFS(root);
        bw.write(result+"");
        bw.close();
    }

    static void DFS(int nowNode){
        if(nowNode == remove) return;

        if(arrList[nowNode].size() == 0)
            result++;
        // 삭제할 노드의 자식들은 어떤 것이 있는지 탐색
        for(int nextNode : arrList[nowNode]){
            DFS(nextNode);
        }
        // 어떤 노드를 지우면 그의 자식 노드들도 같이 삭제

        // 자식이 없다면 리프 노드로 판단 후 카운트 증가
    }
}
