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
      // 점수가 낮게 나온 이유는 아마 굳이 사용해도 되지 않은 List<Integer>을 사용했기 때문 아닐까?
      // list, cnt 대신 바로 answer[i]++를 더해서 리턴했으면 깔끔했을 것 같다...
      return answer;
   }
}