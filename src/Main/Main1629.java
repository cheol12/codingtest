package Main;

import java.io.*;
import java.util.*;

public class Main1629 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());

        long result = pow(A,B,C);


        bw.write(result+"");
        bw.close();
    }

    static long pow(int a, int b, int mod){

        if(b == 0) return 1;

        long n = pow(a, b/2, mod);
        if(b % 2 == 0) return n * n % mod;
        else return (n * n % mod) * a % mod;
    }

}
//https://girawhale.tistory.com/74
// 먼저 제곱은 위의 식처럼 분할이 가능하다. 따라서 제곱을 순차적으로
// 하나씩 곱하면서 구하지 않고, A의 5제곱을 구한 뒤 그 수를 제곱하면
// A의 10제곱을 쉽게 구할 수 있는 것이다. 만약 제곱수가 11(홀수)이라면
// A5(절반)를 제곱한 뒤 그 수에 A를 곱하면 되기 때문에 빠르게
// 답을 구할 수 있게 된다!