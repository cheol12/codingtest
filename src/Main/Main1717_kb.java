package Main;

import java.io.*;
import java.util.*;

class Main1717_kb{
    static int n,m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        parent = new int[n+1];
//        for(int i=0; i<=n; i++){
//            parent[i] = i;
//        }
        Arrays.setAll(parent, (i) -> i);

        for(int i=0; i<m; i++){
            token = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(token.nextToken());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            if(cal == 0) union(start,end);
            else if(cal == 1) {
                if(find(start) == find(end)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.close();
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y) parent[y] = x;
        else parent[x] = y;
    }

    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
