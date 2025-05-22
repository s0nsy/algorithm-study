//+9점
//하우스 로버
class Solution {
   public int solution(int[] money) {
      int first =0;
      int house = money.length;
      int[] dp = new int[house];
      //첫 번째 집 방문을 할 때(마지막 집 방문 불가)
      dp[0]=money[0];
      dp[1]=dp[0];
      for(int i = 2;i<house-1;i++){
         dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
      }
      first=dp[house-2];
      //첫 번째 집을 방문하지 않을 때
      dp= new int[house];
      dp[1]=money[1];
      for(int i = 2;i<house;i++){
         dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
      }
      return Math.max(first,dp[house-1]);
   }
   // 원형 문제를 선형문제로 쪼개기 위해 첫 번째 집을 방문한 경우, 안 한 경우를 나눔.
}