package Main;

import java.util.*;
import java.io.*;

public class Main14891 {
    static int k;
    static int[][] wheels = new int[5][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        for(int i=1; i<=4; i++){
            String temp = br.readLine();
            for(int j=0; j<8; j++){
                wheels[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        k = Integer.parseInt(br.readLine());

        for(int i=1; i<=k; i++){
            token = new StringTokenizer(br.readLine());
            // 톱니 번호
            int num = Integer.parseInt(token.nextToken());
            // 방향 = 1 or -1
            int dir = Integer.parseInt(token.nextToken());

            // 해당 k번째 회전 동작에서 톱니바퀴 4개 모두의 회전 여부 확인
            int[] directions = getDirections(wheels, num, dir);

            for(int j=1; j<=4; j++){
                if(directions[j] != 0){
                    // j번째 톱니를 방향에 맞게 회전하라
                    rotate(wheels[j], directions[j]);
                }
            }
        }

        int answer = 0;

        for(int i=1; i<=4; i++){
            if(wheels[i][0] == 1){
                answer += Math.pow(2,i-1);
            }
        }
        getSum(wheels);

        bw.write(getSum(wheels)+"");
        bw.close();
    }

    static int[] getDirections(int[][] wheels, int num, int dir){
        int[] directions = new int[5];
        // 초기값 설정 = num번째 톱니가 회전할 방향은 dir.
        directions[num] = dir;

        // num번 톱니의 왼쪽 톱니들이 같이 회전해야할지 판단
        for(int i=num; i>1; i--){
            // 같으면 그대로
            if(wheels[i][6] == wheels[i-1][2]){
                break;
            }
            // 다르면 반대로
            directions[i-1] = directions[i] * -1;
        }

        // num번 톱니의 오른쪽 톱니들이 같이 회전해야할지 판단
        for(int i=num; i<4; i++){
            // 같으면 그대로
            if(wheels[i][2] == wheels[i+1][6]){
                break;
            }
            // 다르면 반대로
            directions[i+1] = directions[i] * -1;
        }
        return directions;
    }

    static void rotate(int[] wheels, int dir){
        if(dir == 1){
            int temp = wheels[7];

            for(int i=7; i>0; i--){
                wheels[i] = wheels[i-1];
            }
            wheels[0] = temp;
        }else if(dir == -1){
            int temp = wheels[0];

            for(int i=0; i<7; i++){
                wheels[i] = wheels[i+1];
            }
            wheels[7] = temp;
        }
    }

    static int getSum(int[][] wheel){
        int answer = 0;
        for(int i=1; i<=4; i++){
            if(wheel[i][0] == 1){
                answer += Math.pow(2,i-1);
            }
        }
        return answer;
    }
}

//https://developer-hm.tistory.com/206