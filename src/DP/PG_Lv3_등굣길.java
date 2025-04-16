import java.util.*;
//+12점
class Solution {
   public int solution(int m, int n, int[][] puddles) {
      int answer = 0;
      int[][] dp = new int[n+1][m+1];
      boolean[][] flooded= new boolean[n+1][m+1];
      for(int i = 0;i<puddles.length;i++){
         flooded[puddles[i][1]][puddles[i][0]] = true;
      }
      dp[1][1]=1;
      for(int i =1;i<=n;i++){
         for(int j =1;j<=m;j++){
            if(flooded[i][j])
               dp[i][j]=0;
            else
               dp[i][j]+=dp[i][j-1]%1000000007+dp[i-1][j]%1000000007;
               // 각 위치마다 %1000000007 하기!
         }
      }

      return dp[n][m]%1000000007;
   }
}