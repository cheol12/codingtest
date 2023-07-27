package Main;

import java.io.*;
import java.util.*;

class Main1941{
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] board = new char[5][5];
    static boolean[][] visited;
    static int length = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<length; i++){
            String temp = br.readLine();
            for(int j=0; j<length; j++){
                board[i] = temp.toCharArray();
            }
        }

        BFS();
    }

    static void BFS(){

    }
}