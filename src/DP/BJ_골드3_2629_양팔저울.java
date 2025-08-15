import java.io.IOException;
import java.util.Scanner;
// 17756kb	180ms
public class Main {
   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      int weight = sc.nextInt();
      int[] w = new int[weight + 1];
      int sum = 0;

      for (int i = 1; i <= weight; i++) {
         w[i] = sc.nextInt();
         sum += w[i];
      }

      boolean[][] dp = new boolean[weight + 1][sum + 1];
      dp[0][0] = true;

      for (int i = 1; i <= weight; i++) {
         for (int j = 0; j <= sum; j++) {
            if (dp[i - 1][j]) {
               // dp[i][j]가 첫 번째부터 i번째(w[i])까지 입력된 추가 만들 수 있는 무게 j를 구하기.
               dp[i][j] = true; // w[i] 사용X
               dp[i][j + w[i]] = true; // w[i] 사용
               dp[i][Math.abs(j - w[i])] = true; // 반대쪽 추에 사용
            }
         }
      }
      int marble = sc.nextInt();
      int n = 0;

      for (int i = 0; i < marble; i++) {
         n = sc.nextInt();
         if (n <= sum && dp[weight][n]) {
            System.out.print("Y ");
         } else
            System.out.print("N ");
      }

   }
}
