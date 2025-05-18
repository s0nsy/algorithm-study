import java.util.Scanner;
// 56956kb	260ms
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int K = sc.nextInt();
      int[][] arr = new int[N + 1][2];
      int[][] dp = new int[N + 1][K + 1];
      for (int i = 1; i <= N; i++) {
         arr[i][0] = sc.nextInt();
         arr[i][1] = sc.nextInt();
      }

      //i: 고려한 아이템 순서. 몇 번째까지 고려했는지.
      //j: 배낭 현재 무게
      //dp[i][j]: i번째 고려했으며 무게 j이하일 때의 최대 가치
      for (int i = 1; i <= N; i++) {
         for (int j = 0; j <= K; j++) {
            if (j < arr[i][0])
               dp[i][j] = dp[i - 1][j];
            else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
         }
      }
      System.out.println(dp[N][K]);
   }
}