package Main;

import java.io.*;

public class Main2750_quick {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //
        quickSort(arr, 0, N-1);

        for(int i=0; i<N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }

    static void quickSort(int[] arr, int left, int right) {
        // left = 초기 왼쪽 인덱스, right = 초기 오른쪽 인덱스
        if(left >= right) return;
        int pivot = left;
        int l = left + 1;  // 현재 부분배열의 왼쪽
        int r = right;      // 현재 부분배열의 오른쪽

        // l는 오른쪽으로..
        // r는 왼쪽으로.. 이동하다가
        // 교차되는 시점에서 반복문 종료
        while(l <= r){
            // arr[l]이 arr[pivot]보다 큰 값을 만날 때까지 l++
            while((l <= right) && (arr[l] <= arr[pivot]))
                l++;
            // arr[r]이 arr[pivot]보다 작은 값을 만날 때까지 r--
            while((r >= left+1) && (arr[r] >= arr[pivot]))
                r--;

            //엇갈리면 피벗과 r 교체
            if(l>r){
                swap(arr, r, pivot);
            }
            else{   // 엇갈리지 않으면 부분배열의 왼쪽 오른쪽 서로 교체
                swap(arr, l, r);
            }
        }

        quickSort(arr, left, r-1);  // arr[pivot]보다 작은 값들
        quickSort(arr, r+1, right); // arr[pivot]보다 큰 값들
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//https://hongku.tistory.com/149 그림으로 퀵 정렬 설명
//https://hongku.tistory.com/210

