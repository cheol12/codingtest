package Main;

import java.util.*;
import java.io.*;

class Main14003{
    static int N;
    static int[] suyeol;
    static Integer[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        A = new Integer[N+1];
        suyeol = new int[N+1];

        // 각 인덱스에 해당 부분 수열들을 넣는다.
        ArrayList<Integer>[] suyeol2 = new ArrayList[N+1];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(token.nextToken());
            suyeol2[i] = new ArrayList<>();
        }

        int suyeol_position = 1;
        suyeol[1] = 1;
        suyeol2[1].add(A[1]);
        for(int i=2; i<=N; i++){
            // 어디부터 생각하든 부분 수열 개수는 하나(그 하나에 해당하는 것 = A[i]),
            // suyeol[i]=1로 하는 이유 : ex) {30,40,50,10,20} 같은 경우에서
            // A[4]까지의 부분 수열 개수를 1개로 인식할 수 있다.
            // 따라서 아래 반복문은 A[i] 이전에 A[i]보다 작은 오름차순 배열 속
            // 숫자가 몇 개인지 찾는 과정이라 생각
            suyeol[i] = 1;

            // suyeol[i] = A[1]~A[i]까지 오름차순인 부분 수열 개수
            for(int j=1; j<i; j++){

                if(A[i] > A[j]){    // A[i]가 이전 값(=j)보다 크면
                    // 그리고 A[j]+1이 더 크면 A[j]를 부분 수열 목록에 넣는다
                    if(suyeol[i] < suyeol[j]+1){
                        suyeol2[i].add(A[j]);
                    }
                    // 부분 수열[i]의 개수는 이전 부분 수열보다[j] 반드시 크다.
                    suyeol[i] = Math.max(suyeol[i], suyeol[j]+1);

                }
            }
            // 해당 부분 수열 마지막에 A[i]로 마무리
            suyeol2[i].add(A[i]);
            // 부분 수열 개수를 나타내는 객체를 따로 저장.

            if(suyeol2[i].size() > suyeol_position)
                suyeol_position = i;
        }

        bw.write(String.valueOf(suyeol2[suyeol_position]));
        bw.write(Arrays.toString(suyeol2)+"\n");
        bw.close();
    }
}