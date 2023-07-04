package CodeUp;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] arr;
    static int result = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br =
                new BufferedReader(new FileReader("C:\\EvenOddSumInput.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer token;
        int i = 0;
        while(i<N){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
            i++;
        }

        BFS();

        bw.write(result+"");
        bw.close();
    }

    static void BFS(){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int sum_temp = 0;

                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    sum_temp += arr[nx][ny];
                }
                if(sum_temp % 2 == 0) result += arr[i][j];
            }
        }
    }
}