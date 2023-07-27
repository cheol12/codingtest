package Main;

import java.io.*;
import java.util.*;

class Main1759{
    static int L,C;
    static char[] arr;
    static char[] print;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        arr = new char[C];
        print = new char[L];

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = token.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        DFS(0, 0);
        bw.close();
    }

    static void DFS(int start, int th) throws IOException{
        if(th == L ){
            if(check(print)){
                for(char i : print){
                    bw.write(i);
                }
                bw.write("\n");
            }
            return;
        }

        for(int i = start; i<C; i++){
            print[th] = arr[i];
            DFS(i+1, th+1);
        }

    }

    static boolean check(char[] print){
        int consonant = 0; // 자음
        int vowels = 0;    // 모음

        for(char i : print){
            if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u'){
                vowels++;
            }
            else{
                consonant++;
            }
        }
        if(vowels >= 1 && consonant >= 2) return true;
        else return false;
    }
}
// a c i s t w