import java.util.Scanner;
// 30360kb 372ms
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int K = sc.nextInt();
      int N = sc.nextInt();
      int[] arr = new int[K];
      int max = 0;
      for (int i = 0; i < K; i++) {
         arr[i] = sc.nextInt();
         max = Math.max(max, arr[i]);
      }
      int left = 1, right = max;
      int cnt = 0;
      while (left <= right) {
         cnt = 0;
         int mid = (left + right) / 2;
         for (int i : arr) {
            cnt += i / mid;
         }
         if (cnt < N)
            right = mid - 1;
         else
            left = mid + 1;

      }
      System.out.println(right);
   }
}