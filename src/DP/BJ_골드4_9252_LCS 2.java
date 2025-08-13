import java.io.IOException;
import java.util.Scanner;

//21824kb	216ms
public class Main {
   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();
      String str1 = sc.nextLine();
      String str2 = sc.nextLine();
      int len1 = str1.length();
      int len2 = str2.length();
      // str1의 처음 i글자와 str2의 처음 j글자에서 lcs 길이
      int[][] dp = new int[len1 + 1][len2 + 1];

      for (int i = 1; i <= len1; i++) {
         for (int j = 1; j <= len2; j++) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1] + 1;
            } else
               dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
         }
      }
      int i = len1;
      int j = len2;
      while (i > 0 && j > 0) {
         if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            sb.append(str1.charAt(i - 1));
            i--;
            j--;
         } else if (dp[i - 1][j] >= dp[i][j - 1]) {
            i--;
         } else {
            j--;
         }
      }
      // 역추적이므로 반대로 저장되어있다.
      sb.reverse();
      System.out.println(dp[len1][len2]);
      if (dp[len1][len2] > 0) {
         System.out.println(sb.toString());
      }

   }
}
