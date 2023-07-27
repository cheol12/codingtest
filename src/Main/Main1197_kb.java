package Main;

import java.io.*;
import java.util.*;

class Main1197_kb{
    static class Node{
        int start, end, weight;
        Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int V, E;    // V : 정점 수, E : 간선 수
    static Node[] nodeArr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());

        parent = new int[V+1];
        nodeArr = new Node[E+1];

        for(int i=0; i<E; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());
            nodeArr[start] = new Node(start, end, weight);
        }

        for(int i=1; i<=V; i++){
            parent[i] = i;
        }

        Arrays.sort(nodeArr, (s1, s2) -> s1.weight - s2.weight);

        for(int i=1; i<=V; i++){
            System.out.print(i + "번에 연결된 간선 -- ");
            for(Node node : nodeArr){
                System.out.print("끝점:" + node.end + ", 가중치:" + node.weight + "// ");
            }
            System.out.println();
        }

        int ans = 0;    // 가중치 합

        for(Node node : nodeArr){

            if(find(node.start) != find(node.end)){
                union(node.start, node.end);
                ans += node.weight;
            }
        }
        System.out.println(ans);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[x] = y;
        }
    }

    static boolean sameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }
}
