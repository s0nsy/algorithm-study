import java.util.*;
//+7점
class Solution {
   public int solution(int[] people, int limit) {
      int answer = 0;
      Arrays.sort(people);
      int start = 0;
      int end = people.length-1;
      while(start<people.length&&end>=0&&start<=end){
         if(start==end){
            answer++;
            break;
         }
         if(people[start]+people[end]<=limit){
            answer++;
            start++;
            end--;
         }else{
            end--;
            answer++;
         }

      }

      return answer;
   }
}