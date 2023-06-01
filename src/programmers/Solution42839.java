package programmers;

import java.util.*;
import java.io.*;

// 프로그래머스
//완전탐색
//소수 찾기
class Solution42839 {
    static int[] answer;
    static HashSet<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        String numbers = "17";

        //answer = solution(today, terms, privacies);
        //bw.write(Arrays.toString(answer)+"");

        bw.write(solution(numbers)+"");

        bw.close();
    }
    public static int solution(String numbers) {

        // 크게 3단계
        // 1. 모든 조합의 숫자를 만든다.
        // 2. 소수의 개수만 센다.
        // 3. 소수의 개수를 반환한다.

        int count = 0;  // 소수 개수

       // 1. 모든 조합의 숫자를 만든다.
        dfs("", numbers);

        System.out.println(numberSet);

        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()){
            int temp = it.next();
            if(isPrime(temp)) count++;
        }

        // 3. 소수의 개수를 반환한다.
        return count;
    }

    static void dfs(String comb, String others){
        // 1. 현재 조합을 set에 추가한다.
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for(int i=0; i<others.length(); i++){
            dfs(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }


    static boolean isPrime(int num){
        if(num == 0 || num == 1)
            return false;

        // 에라토스테네스의 체의 limit를 계산
        int lim = (int)Math.sqrt(num);

        // 에라토스테네스의 체에 따라 limit까지만 배수 여부 확인
        for(int i = 2; i <= lim; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
// https://coding-grandpa.tistory.com/81
// https://www.youtube.com/watch?v=pF368QqdQb4
// iterator 설명 13분
// iterator는 hasNext(), next(), remove() 3가지 이용
// 쓰는 이유 : 자료 구조에 구애받지 않고 같은 코드 형태를 반복문 역할로 활용 가능