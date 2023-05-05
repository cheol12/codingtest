package Main;

import java.io.*;
import java.util.*;

public class Main18870 {
    static int N;    // X좌표 개수 N
    static int[] X,A;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        X = new int[N];

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            X[i] = Integer.parseInt(token.nextToken());
        }

        A = X.clone();
        Arrays.sort(A);
        int rank = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0; i<N; i++){
            if(!hashmap.containsKey(A[i])){
                hashmap.put(A[i], rank);
                rank++;
            }
        }

        for(int i=0; i<N; i++){
            bw.write(hashmap.get(X[i])+"\n");
        }
        bw.close();
    }
}
