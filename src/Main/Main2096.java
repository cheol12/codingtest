package Main;

import java.io.*;
import java.util.*;

public class Main2096 {
    static int N;
    static int[][] board;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        board = new int[N+1][3];
        int[][] board_max = new int[N+1][3];
        int[][] board_min = new int[N+1][3];

        for(int i=1; i<=N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i=0; i<=N; i++){
            board_max[i] = board[i].clone();
            board_min[i] = board[i].clone();
        }

        for(int i=2; i<=N; i++) {
            board_max[i][0] += Math.max(board_max[i - 1][0], board_max[i - 1][1]);
            board_max[i][1] += Math.max(Math.max(board_max[i - 1][0], board_max[i - 1][1]), board_max[i - 1][2]);
            board_max[i][2] += Math.max(board_max[i - 1][1], board_max[i - 1][2]);
        }

        for(int i=2; i<=N; i++) {
            board_min[i][0] += Math.min(board_min[i-1][0],board_min[i-1][1]);
            board_min[i][1] += Math.min(Math.min(board_min[i-1][0],board_min[i-1][1]), board_min[i-1][2]);
            board_min[i][2] += Math.min(board_min[i-1][1],board_min[i-1][2]);
        }

        int result_max = Math.max(Math.max(board_max[N][0], board_max[N][1]), board_max[N][2]);
        int result_min = Math.min(Math.min(board_min[N][0], board_min[N][1]), board_min[N][2]);

        bw.write(result_max + " " + result_min);
        bw.close();
    }
}
//https://hanyeop.tistory.com/366
//위 링크에서 2차원 배열을 복사할 때 유의할 점, 깊은 복사, 얕은 복사의 차이 참고.
// 깊은 복사 : 주소 달라서 값 변경시 달라짐(=새 객체 생성), 얕은 복사 : 주소 같아서 값 변경시 연동

//https://moonsbeen.tistory.com/191 - 비슷한데 나보다 더 간단한 풀이