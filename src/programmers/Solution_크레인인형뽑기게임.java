package programmers;

import java.util.*;
import java.io.*;

class Solution_크레인인형뽑기게임 {
    public static void main(String[] args) throws IOException {

        int[][] board = { {0,0,0,0,0}, {0,0,1,0,3},
                {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1} };
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for(int i = 0; i<moves.length; i++){
            int pickNum = moves[i]-1;
            for(int j = 0; j<board.length; j++){
                if(board[j][pickNum] == 0) continue;
                int doll ;

                if(!stack.isEmpty()) {
                    doll = stack.peek();
                    if(doll == board[j][pickNum]){
                        stack.pop();
                        board[j][pickNum] = 0;
                        answer += 2;
                    }
                    else{
                        stack.push(board[j][pickNum]);
                        board[j][pickNum] = 0;
                    }
                    break;
                }
                else{
                    stack.push(board[j][pickNum]);
                    board[j][pickNum] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}