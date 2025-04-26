import java.util.*;
//+4점
class Solution {
   public int[] solution(int[] prices) {
      List<Integer> list = new ArrayList<>();
      for(int i = 0;i<prices.length;i++){
         int cnt =0;
         for(int j =i+1;j<prices.length;j++){
            cnt++;
            if(prices[i]>prices[j])
               break;
         }
         list.add(cnt);
      }
      int[] answer = new int[list.size()];
      for(int i =0;i<answer.length;i++){
         answer[i]=list.get(i);
      }
      return answer;
   }
}