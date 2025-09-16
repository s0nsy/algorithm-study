import java.io.IOException;
import java.util.Scanner;
//	18112kb	204ms
public class Main {
   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] mem = new int[n + 1];
      int[] inactive = new int[n + 1];

      for (int i = 1; i <= n; i++) {
         mem[i] = sc.nextInt();
      }
      int sum = 0;
      for (int i = 1; i <= n; i++) {
         inactive[i] = sc.nextInt();
         sum += inactive[i];
      }
      int[] dp = new int[sum + 1];

      // j를 비용으로 잡고 dp[i][j]를 max 메모리로 관리하기.
      for (int i = 1; i <= n; i++) {
         for (int j = sum; j >= inactive[i]; j--) {
            dp[j] = Math.max(dp[j], dp[j - inactive[i]] + mem[i]);
         }
      }
      for (int i = 0; i <= sum; i++) {
         if (dp[i] >= m) {
            System.out.println(i);
            break;
         }
      }
   }
}
