import java.util.*;
//+9점
class Solution {
   public int solution(int[] citations) {
      int answer = 0;
      Arrays.sort(citations);

      for(int i =0;i<citations.length;i++){
         if(citations[i]>=citations.length-i)
            answer= Math.max(answer,citations.length-i);
            // Math.max 사용하지 않고 그냥 바로 return citations.length-i 처리하는 것이 효율적이다.
      }

      return answer;
   }
}
