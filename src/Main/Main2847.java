package Main;

import java.io.*;
import java.util.*;

class Main2847{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int currMin = Integer.MAX_VALUE;
        int count = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            currMin = Math.min(currMin, arr[i]);
        }

        // i-1인덱스는 i보다 작아야 한다
        for(int i=N-1; i>=1; i--){
            if(arr[i-1] >= arr[i]) {
                count += arr[i-1] - arr[i] + 1;
                arr[i-1] = arr[i]-1;
            }
        }

        bw.write(count+"");
        bw.close();
    }
}
