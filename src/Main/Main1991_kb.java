package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1991_kb {
    static ArrayList<Character>[] arrList;
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        arrList = new ArrayList[N];

        for(int i=0; i<N; i++){
            arrList[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            char start = token.nextToken().charAt(0);
            char end1 = token.nextToken().charAt(0);
            char end2 = token.nextToken().charAt(0);
            arrList[start - 'A'].add(end1);
            arrList[start - 'A'].add(end2);
        }

        // 'C' - 'A'

        preOrderDFS('A');
        bw.write("\n");
        inOrderDFS('A');
        bw.write("\n");
        postOrderDFS('A');
        bw.close();
    }

    static void preOrderDFS(char nowNode) throws IOException{
        char left = arrList[nowNode - 'A'].get(0);
        char right = arrList[nowNode - 'A'].get(1);

        bw.write(nowNode);

        if(left != '.')
            preOrderDFS(left);

        if(right != '.')
            preOrderDFS(right);
    }
    static void inOrderDFS(char nowNode) throws IOException{
        char left = arrList[nowNode - 'A'].get(0);
        char right = arrList[nowNode - 'A'].get(1);

        if(left != '.')
            inOrderDFS(left);

        bw.write(nowNode);

        if(right != '.')
            inOrderDFS(right);
    }
    static void postOrderDFS(char nowNode) throws IOException{
        char left = arrList[nowNode - 'A'].get(0);
        char right = arrList[nowNode - 'A'].get(1);


        if(left != '.')
            postOrderDFS(left);

        if(right != '.')
            postOrderDFS(right);

        bw.write(nowNode);
    }

}
