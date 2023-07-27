package Main;

import java.io.*;
import java.util.*;

public class Main1414_kb {
    static class Edge{
        int start,end,value;
        Edge(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    static int[] parent;
    static int N,sum;
    static PriorityQueue<Edge> queue;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            char[] tempc = token.nextToken().toCharArray();
            for(int j=0; j<N; j++){
                int temp = 0;
                if(tempc[j] >= 'a' && tempc[j] <= 'z')
                    temp = tempc[j] - 'a' + 1;
                else if(tempc[j] >= 'A' && tempc[j] <= 'Z')
                    temp = tempc[j] - 'A' + 27;

                sum = sum + temp;
                if(i != j && temp != 0) queue.add(new Edge(i,j,temp));
            }
        }

        parent = new int[N];

        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;

        while(!queue.isEmpty()){
            Edge now = queue.poll();
            if(find(now.start) != find(now.end)){
                union(now.start,now.end);
                result = result + now.value;
                useEdge++;
            }
        }

        if(useEdge == N-1) bw.write(String.valueOf(sum - result));
        else bw.write("-1");

        bw.close();
    }

    // a의 대표노드를 찾는 연산
    static int find(int a){
        if(a == parent[a]) return a;    // 본함수 : 최상위 노드가 자신일 때 자신을 리턴하며 멈추기.
        else return parent[a] = find(parent[a]);    // 재귀(본함수 결과에 맞게 나올 때까지 반복)
    }

    // union 연산 : a,b의 각 대표 노드가 다르다면 x,y를 연결하는 연산
    static void union(int a, int b){    // union 연산 : 대표 노드끼리 연결하는 연산
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}
