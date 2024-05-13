package Swea;

import java.util.*;
import java.io.*;

class SolutionFlatten
{
    public static void main(String args[]) throws Exception

    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] boxHeight = new int[100];
            int N = Integer.parseInt(br.readLine());
            int answer = 0;

            token = new StringTokenizer(br.readLine());
            for(int i=0; i < 100; i++){
                boxHeight[i] = Integer.parseInt(token.nextToken());
            }

            Arrays.sort(boxHeight);

            for(int i=0; i<N; i++){
                boxHeight[0] += 1;
                boxHeight[99] -= 1;
                Arrays.sort(boxHeight);
            }
            answer = boxHeight[99] - boxHeight[0];
            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.close();
    }
}
