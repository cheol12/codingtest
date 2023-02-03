package CodeUp;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String a = br.readLine();

        String b[] = a.split("-");

        for(int i=0; i<b.length; i++){
            bw.write(b[i]);
        }
        bw.close();
    }
}