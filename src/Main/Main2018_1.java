package Main;

import java.io.*;
import java.util.StringTokenizer;

public class Main2018_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 1;

        for(int i=1; i<=N/2; i++){
            int temp = i;
            for(int j=i+1; j<=N/2 + 1; j++){
                temp += j;
                if(temp == N) {
                    count++;
                    break;
                }
                else if(temp > N) break;
            }
        }

        bw.write(count+1+"");
        bw.close();
    }
}
