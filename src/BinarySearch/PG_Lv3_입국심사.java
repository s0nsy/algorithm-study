import java.util.*;

//+11점

import java.util.*;
class Solution {
   long answer=1;
   public long solution(int n, int[] times) {
      Arrays.sort(times);
      long start =1;
      long end=(long)n*times[times.length-1];
      while(start<=end){
         long mid= (start+end)/2;
         long sum =0;
         for(int i =0;i<times.length;i++){
            sum+=mid/times[i];
         }
         if(sum >=n){
            answer= mid;
            end= mid-1;
         }else if(sum<n){
            start=mid+1;
         }
      }
      return answer;
   }
}