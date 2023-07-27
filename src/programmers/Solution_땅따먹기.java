package programmers;

import java.util.*;
import java.io.*;

class Solution_땅따먹기 {
    public static void main(String[] args) throws IOException {

        int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};

        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {
        int answer = 0;
        int landLen = land.length;
        for(int i=1; i<landLen; i++){
            for(int j=0; j<land[0].length; j++){
                if(j == 0){
                    land[i][j] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
                }
                else if(j == 1){
                    land[i][j] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
                }
                else if(j == 2){
                    land[i][j] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
                }
                else if(j == 3){
                    land[i][j] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
                }
            }
        }

        answer = Math.max(land[landLen-1][0], Math.max(land[landLen-1][1], Math.max(land[landLen-1][2], land[landLen-1][3])));

        System.out.println("Hello Java");

        return answer;
    }
}