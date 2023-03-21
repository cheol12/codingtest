package Main;

import java.util.*;
import java.io.*;

public class Main1722 {
    //수학
    //구현
    //조합론
    static int N;
    static int[][] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        //A = new int[fact(N)+1][N+1];    // 처음에는 모든 경우의 수를 구하려고 했음.

        int Q;                      // 소문제 번호
        long F[] = new long[21];    // F[i] = i! = 팩토리얼 값 나타내기
        int S[] = new int[21];      // 출력할 K번째 순열
        boolean visit[] = new boolean[21];  // 사용 숫자 나타내기

        N = Integer.parseInt(br.readLine());    // 범위 : 1~20

        token = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(token.nextToken());    // 소문제 번호 : 1 or 2

        F[0] = 1;

        for(int i=1; i<=N; i++){    // 나타낼 수 있는 순열의 총 개수
            F[i] = F[i - 1] * i;
        }

        // 경우의 수들을 적어 놓고 잘 관찰해보면 맨 앞자리 숫자에 따라 각각 6개의
        // 경우가 있다는 것을 알 수 있다. 즉, 길이가 N인 순열에서 앞자리 숫자가 i개
        // 결정되었을 때 각 숫자마다 (N-i)! 개의 경우가 나온다는 것이다.
        //
        // 소문제 Q = 1번일 때, k번째 순열을 나타내는 N개의 수 출력.
        // ex) N = 4, Q = 1, K = 3
        if(Q == 1){
            long K = Long.parseLong(token.nextToken());

            // 구하려는 순열의 i번째 위치.
            for(int i = 1; i <= N; i++){    // i=1 / i=2

                // j = 순열에 들어갈 숫자
                // cnt = 확정되지 않은 수 중에서 cnt번째의 수
                // 만약, S[1]=1로 확정된 상태에서 cnt=2라면,
                // 이는 확정되지 않은 (2,3,4) 중 2번째인 3을 뜻한다.

                // j=1, i번째 위치에 j가 들어가는지 판단하기. (->1번째에 1이 들어가는 것 확인)
                // j=1, 1은 이미 순열에 들어감/ j=2, cnt=1일 때, K<=cnt*F[N-i]을 통해
                // 확정되지 않은 1(cnt)번째 숫자인 2(j)는 2(i)번째에 들어갈 수 없는 것 확인
                // j=2, cnt=2, 3<=2*2, 확정되지 않은 2번째 숫자인 3은
                for(int j = 1, cnt = 1; j <= N; j++){

                    // visit[1] = false->true / visit[2] = false
                    if(visit[j]) continue;  // 이미 순열에 들어간 숫자는 건너뛰기.

                    // K에 따라 각 자리에 들어갈 수 있는 수 찾기
                    // i=1,j=1,cnt=1,K=3, 3 <= 1 * 6(성립)
                    // i=2,j=2,cnt=1,K=3, 3 <= 1 * 2(성립X) >> j=3, cnt=2, 3<=2*2(성립)
                    // 아래 if문은 N=4일 때, 총 순열의 개수가 N!인 것을 이용한다.
                    // K값이 1~6 사이에 있으면 맨 앞자리=1, 7~12에 있으면 맨 앞자리=2,
                    // 13~18에 있으면 맨 앞자리=3, 19~24에 있으면 맨 앞자리=4.
                    // => 결국 K값에 따라 = 범위값이 N-1!인 N개의 구간 중 K가 어디인지에 따라 맨 앞자리가 정해진다.
                    // 이를 모든 자리마다 반복.
                    if(K <= cnt * F[N - i]){

                        // K = 3 - 0*6 = 3
                        // K = 3 - 1*2 = 3 - 2 = 1
                        K -= ((cnt - 1) * F[N - i]);
                        S[i] = j;   // S[1] = 1 / S[2] = 2
                        visit[j] = true;    // visit[1] = true / visit
                        break;
                    }
                    cnt++;
                }
            }
            // S[1] = 1 => i=1, j=1, cnt=1 ,K=3 => i=1번째 자리에는 확정되지 않은 수 중 cnt=1번째 숫자인 j=1이다.

            // S[2] = 3 => i=2, j=3, cnt=2, K=1 => i=2번째 자리에는 확정되지 않은 수 중 cnt=2번째 숫자인 j=3이다. 이는 K
            // S[3] = 2 => i=3,
            // S[4] = 4 => i=4,
            for(int i = 1; i <= N; i++){
                bw.write(String.valueOf(S[i]) + " ");
            }
        }

        // 소문제 = 2번일 때, N개의 수가 몇 번째 수열인지 출력(K로 출력해보기)
        else if(Q == 2){
            long K = 1;
            for(int i=1; i<=N; i++){
                S[i] = Integer.parseInt(token.nextToken());
                long cnt = 0;
                for(int j=1; j<S[i]; j++){
                    if(!(visit[j])) cnt++;  // 미사용 숫자 개수만큼 카운트
                }
                // 맨 앞자리인 S[1]=1이면 K=1부터 시작, S[1]=2이면 K=7부터 시작, S[1]=3이면 K=13부터 시작...
                K += cnt * F[N-i];  // 자리수 개수에 따라 순서 더해주기
                visit[S[i]] = true;
            }
            bw.write(String.valueOf(K));
        }
       bw.close();
    }

}
//https://it-earth.tistory.com/115