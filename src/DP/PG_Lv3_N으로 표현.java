import java.util.*;

//+8점
class Solution {
   public int solution(int N, int number) {
      int answer = 9;
      Set<Integer>[] dp = new HashSet[9];
      for(int i=1;i<9;i++){
         dp[i]=new HashSet<>();

         dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
         for(int j = 1;j<i;j++){
            for(int x: dp[j]){
               for(int y: dp[i-j]){
                  dp[i].add(x+y);
                  dp[i].add(x-y);
                  dp[i].add(x*y);
                  if(y!=0) dp[i].add(x/y);
               }
            }
         }
         if(dp[i].contains(number)) answer= Math.min(answer,i);
         // 굳이 Math.min 사용할 필요 없이 바로 return i 해주는 것이 효율적.
      }
      if(answer==9)
         return -1;
      else return answer;
   }
}