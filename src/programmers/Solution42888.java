package programmers;

import java.util.*;
import java.io.*;

class Solution42888 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] record = new String[N];

        for(int i=0; i<record.length; i++){
            record[i] = br.readLine();
        }

        bw.write(Arrays.toString(solution(record)));
        bw.close();
    }
    public static String[] solution(String[] record) {
        String[] answer = {};

        String[] sub_answer = new String[record.length];

        String[][] userData = new String[record.length][3];

        int count = 0;

        for(int i=0; i<record.length; i++){

            userData[i][0] = record[i].split(" ")[0];
            if(userData[i][0].equals("Change")) count++;
            userData[i][1] = record[i].split(" ")[1];
            if(userData[i][0].equals("Leave")) continue;
            userData[i][2] = record[i].split(" ")[2];

        }
        // record에 값을 넣고
        //record에 있는 3가지 데이터를 userData에 넣는다

        for(int i=0; i<record.length; i++){

            if(userData[i][0].equals("Enter")){
                sub_answer[i] = userData[i][2] + "님이 들어왔습니다.";
                // 이전에 있었던 result 데이터 중 id가 일치하면
                for(int j=0; j<i; j++){
                    if(userData[j][1].equals(userData[i][1])){
                        // 나갔을 때 userData[j][2] 을 인식할 수 없다.
                        sub_answer[j] = sub_answer[j].replaceFirst(sub_answer[j].substring(0,sub_answer[j].indexOf("님이")),userData[i][2]);
                        userData[j][2] = userData[i][2];
                    }
                }

            }
            else if(userData[i][0].equals("Leave")){
                // 최근에 설정한 닉네임 선택해서 나가기
                for(int j=i-1; j>=0; j--){
                    if(userData[j][1].equals(userData[i][1]) && !userData[j][2].equals("")){
                        sub_answer[i] = userData[j][2] + "님이 나갔습니다.";
                        break;
                    }
                }
            }

            // change -> 이전에 해당 아이디 흔적이 있다면 다 같이 변경
            else if(userData[i][0].equals("Change")){
                // 이전에 result에 넣은 모든 같은 id의 정보를 탐색해서 바꾼다
                for(int j=0; j<i; j++){
                    if(userData[j][1].equals(userData[i][1])){
                        if(userData[j][0].equals("Change")) continue;
                        //sub_answer[j=5]:ffff님이 들어왔습니다 => (userData[j=5]의 ffff를 -> userData[i=6]의 gggg로 바꾼다.) => gggg님이 들어왔습니다
                        //sub_answer[j=5]:gggg님이 들어왔습니다 => (userData[j=5]의 ffff를 -> userData[i-7]의 hhhh로 바꾼다.)
                        // => userData[j=5]의 ffff가 answer[j=5]안에 없기 때문에 바꾸지 못함
                        // 그럼 userData[j=5]의 ffff를 바꾸던가,
                        sub_answer[j] = sub_answer[j].replaceFirst(sub_answer[j].substring(0,sub_answer[j].indexOf("님이")),userData[i][2]);
                        userData[j][2] = sub_answer[j].replaceFirst(sub_answer[j].substring(0,sub_answer[j].indexOf("님이")),userData[i][2]);
//                        userData[j][2] = userData[i][2];

//                        sub_answer[j] = sub_answer[j].replaceAll(userData[j][2],userData[i][2]);
                    }
                }
            }
        }

        ArrayList<String> answerList = new ArrayList<>();

        for(int i=0; i<sub_answer.length; i++) {
            if(sub_answer[i] != null) answerList.add(sub_answer[i]);
        }

        answer = new String[answerList.size()];

        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}