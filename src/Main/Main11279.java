package Main;

import java.io.*;
import java.util.*;

public class Main11279 {
    static int N,x;
    static PriorityQueue<Integer> array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        array = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(array.isEmpty()) bw.write("0\n");
                else bw.write(array.poll()+"\n");
            }else{
                array.add(x);
            }
        }
        bw.close();
    }
}