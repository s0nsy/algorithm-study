import java.util.Arrays;
import java.util.Scanner;
// 17828kb	172ms
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      int answer = 0;
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }
      Arrays.sort(arr);

      int prev = 0;
      // 배열의 값이 양수인 경우, 2 이상의 수는 큰 값끼리 곱한 값을 더하면 된다.
      // 배열의 값이 1인 경우, 더해야 한다.
      for(int i = n-1;i>=0;i--){
         if(arr[i]<=0) break;
         if(arr[i]>=2){
            if(prev==0) prev=arr[i];
            else{
               answer+=prev*arr[i];
               prev=0;
            }
         }else if(arr[i]==1){
            answer+=prev+arr[i];
            prev=0;
         }
      }
      if (prev != 0) {
         answer += prev;
         prev = 0;
      }
      int cnt0 = 0; // 0의 경우 음수의 개수가 홀수인 경우 해당 값과 곱하여 0을 만들어야 한다.
      for (int i = 0; i < n; i++) {
         if(arr[i]>0) break;
         if (arr[i] == 0) {
            cnt0++;
            continue;
         }
         if (prev == 0)
            prev = arr[i];
         else {
            answer += prev * arr[i];
            prev = 0;
         }
      }
      if (prev != 0)
         if (cnt0 == 0)
            answer += prev;

      System.out.println(answer);
   }
}

// 가독성을 높이기 위해 arr에 모든 수를 넣는 것이 아닌 양수(2이상) List, 음수 List, 1, 0 이렇게 네 개로 진행하는 것이 직관적.