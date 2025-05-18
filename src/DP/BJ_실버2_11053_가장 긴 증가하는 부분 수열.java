import java.util.*;
// 21184kb 252ms
public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
         arr[i] = sc.nextInt();
      }
      int[] dp = new int[N];
      for (int i = 0; i < N; i++) {
         dp[i] = 1;
         for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j])
               dp[i] = Math.max(dp[i], dp[j] + 1);
         }
      }
      Arrays.sort(dp);
      System.out.println(dp[N - 1]);
   }
}