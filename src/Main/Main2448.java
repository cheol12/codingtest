package Main;

import java.io.*;
import java.util.*;

class Main2448{
    static int N;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new String[N][N*2-1];

        dfs(N, 0, N-1);

        for(int i=0; i<N; i++){
            for(int j=0; j<N*2-1; j++){
                if(arr[i][j] == null) bw.write(" ");
                else bw.write("*");
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void dfs(int size, int x, int y){

        if(size == 3){
            arr[x][y] = "*";
            arr[x+1][y-1] = arr[x+1][y+1] = "*";
            arr[x+2][y-2] = arr[x+2][y-1] = arr[x+2][y]
                    = arr[x+2][y+1] = arr[x+2][y+2] = "*";
            return;
        }
        else{
            dfs(size/2, x, y);
            dfs(size/2, x + size/2, y - size/2);
            dfs(size/2, x + size/2, y + size/2);
        }
    }
}
//https://velog.io/@jii0_0/%EB%B0%B1%EC%A4%80-2448.-%EB%B3%84-%EC%B0%8D%EA%B8%B0-11-Java