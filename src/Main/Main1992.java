package Main;

import java.io.*;
import java.util.*;

class Main1992{
    static int N;
    static int[][] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(temp.substring(j,j+1));
            }
        }

        DFS(N, 0, 0);

        bw.close();
    }

    static void DFS(int size, int x, int y) throws IOException{

        if(check(size, x, y)){
            if(arr[x][y] == 0) bw.write("0");
            else bw.write("1");
        }
        else{
            bw.write("(");
            DFS(size/2, x, y);
            DFS(size/2, x, y + size/2);
            DFS(size/2, x + size/2, y);
            DFS(size/2, x + size/2, y + size/2);
            bw.write(")");
        }
    }

    static boolean check(int size, int x, int y){
        int temp = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != temp) return false;
            }
        }
        return true;
    }
}
