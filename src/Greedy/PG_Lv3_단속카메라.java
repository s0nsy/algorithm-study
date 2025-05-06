import java.util.*;
//+8점
class Solution {
   public int solution(int[][] routes) {
      int answer=0;
      Arrays.sort(routes,(a,b)->a[1]-b[1]);
      int lastCamera= routes[0][0]-1;
      for(int[] route: routes){
         if(route[0]>lastCamera){
            answer++;
            lastCamera=route[1];
         }
      }

      System.out.println(answer);
      return answer;
   }
}