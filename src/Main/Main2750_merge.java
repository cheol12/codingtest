package Main;

import java.io.*;

public class Main2750_merge {
    static int[] arr;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[arr.length];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, temp, 0, N-1);

        for(int i=0; i<N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }

    static void mergeSort(int[] arr, int[] temp, int left, int right){
        if(left>=right) return;

        int center = (left + right) / 2;
        mergeSort(arr, temp, left, center);
        mergeSort(arr, temp, center+1, right);

        // temp에 덮어씌워간다다
        merge(arr, left, center, right);
    }

    static void merge(int[] arr, int left, int center, int right){
        int p = left;   // 분할된 두 배열 중 왼쪽 배열의 첫 인덱스
        int q = center+1;  // 분할된 두 배열 중 오른쪽 배열의 첫 인덱스
        
        // 위의 두 수를 비교하고 temp에 저장할 인덱스
        int index = left; 

        // index를 기준으로 탐색한다
        while(p <= center && q <= right){
            // 분할된 것 중 작은 것을 temp[]배열에 넣는다.
            // 왼 배열의 값이 더 작은 경우, temp에 입력
            if(arr[p] < arr[q]){
                temp[index] = arr[p];
                p++;
            }
            // 오른 배열의 값이 더 작은 경우, temp에 입력
            else if(arr[p] > arr[q]){
                temp[index] = arr[q];
                q++;
            }

            // 왼쪽 배열을 전부 완료한 경우
            else if(p > center){
                temp[index] = arr[q];
                q++;
//                for(int i=q; i<=right; i++){
//                    temp[index++] = arr[i];
//                }
            }
            else if(q > right){
                temp[index] = arr[p];
                p++;
//                for(int i=p; i<=center; i++){
//                    temp[index++] = arr[i];
//                }
            }
            index++;
        }


        for(int i=left; i<=right; i++){
            arr[i] = temp[i];
        }
    }

}
//https://banjjak1.tistory.com/49