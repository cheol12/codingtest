package Main;

import java.io.*;
import java.util.*;

public class Main17219 {

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());    // 총 사이트 수
        M = Integer.parseInt(token.nextToken());    // 찾으려는 사이트 수

        Map<String, String> hashmap = new HashMap<>();
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());

            String site = token.nextToken();
            String pw = token.nextToken();
            hashmap.put(site, pw);
        }

        for(int i=0; i<M; i++){
            String find = br.readLine();
            bw.write(hashmap.get(find)+"\n");
        }

        bw.close();

    }
}
