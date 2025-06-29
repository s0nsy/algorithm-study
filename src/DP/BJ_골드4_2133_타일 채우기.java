import java.util.Scanner;
// 17720kb	172ms
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int[] dp = new int[31];
      dp[0] = 1;
      dp[2] = 3;
      for (int i = 4; i <= N; i += 2) {
         dp[i] += dp[i - 2] * 3;
         for (int j = 2; j <= i; j += 2) {
            dp[i] += dp[i - j] * 2;
         }
      }
      System.out.println(dp[N]);
   }
}
