import java.util.*;
class Solution {
   public int solution(int[] scoville, int K) {
      int answer = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>();

      for( int i : scoville)
         pq.offer(i);

      while(pq.size()>1&&pq.peek()<K){
         int first = pq.poll();
         int second = pq.poll();
         int newScov= first+ second*2;
         pq.offer(newScov);
         answer++;
      }
      return pq.peek() >=K?answer:-1;
   }
}