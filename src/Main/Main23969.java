package Main;

import java.io.IOException;
import java.util.*;
// 6 10
// 9 8 4 2 1 3
// 입력값으로 하기 좋음, 13이 총 횟수
public class Main23969 {
    // 문제 제목 : 알고리즘 수업 - 버블 정렬2
    // 알고리즘 분류 : *구현, *정렬, 시뮬레이션
    public static void main(String[] args) throws IOException {

        // 리스트에서 인접한 두 원소의 크기 비교,
        // 오른쪽보다 왼쪽이 크다면 둘이 위치 변경 -> 리스트 안에서 왼쪽이 큰 경우가 없어질 때까지 반복
        // 결국 마지막 결과는 순서대로 나타남
        // 정렬 과정에서 원소의 이동이 마치 거품이 수면위로 올라오는 것 같다고 해서 거품(Bubble) 이라는 이름이 붙었다고 한다.

        // K번의 스왑 뒤에 리스트 결과 출력, 버블 정렬이 끝나도 스왑 횟수가 K에 못미친다면 -1 출력.
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> bubblelist = new ArrayList<Integer>();     // 버블 정렬 실행할 리스트 객체

        int N = sc.nextInt();       // 리스트 안의 원소 개수
        int K = sc.nextInt();       // 스왑할 횟수 설정
        sc.nextLine();

        for(int i=0; i<N; i++){
            bubblelist.add(sc.nextInt());   // 리스트 원소들에게 각각의 값 설정
        }

        int count = 0;     // 버블 정렬 안에서 실행한 스왑 횟수 (K와 비교할 예정)

        for(int j = 0; j < N-1; j++) {   // 마지막에 있는 숫자가 가장 작을 경우에도 문제없이 진행하기 위해 N-1번으로 설정

            for (int i = 0; i < N - 1; i++) {
                if (bubblelist.get(i) > bubblelist.get(i + 1)) {    // i번째가 i+1번째보다 크다면 서로 위치 변경
                    int temp = bubblelist.get(i);
                    bubblelist.set(i, bubblelist.get(i + 1));
                    bubblelist.set(i + 1, temp);
                    count++;                                    // 스왑할 때마다 카운트+1
                }
                if ((K == count)) break;
            }
            if ((K == count)) break;
        }

        System.out.println(bubblelist.toString());
        System.out.println(count);

        if(K > count) {
            System.out.println(-1);
        }else{
            for (int i = 0; i < N; i++) {
                System.out.print(bubblelist.get(i) + " ");
            }
        }
    }
}
