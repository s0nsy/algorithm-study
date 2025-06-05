import java.util.*;
class Solution {
   public int solution(int[] scoville, int K) {
      int answer = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>();

      for( int i : scoville)
         pq.offer(i);

      while(pq.size()>1&&pq.peek()<K){
         int first = pq.poll(); // 우선 순위 큐를 사용하여 항상 가장 맵지 않은 두 음식 꺼내기
         int second = pq.poll();
         int newScov= first+ second*2;
         pq.offer(newScov); // 새로 계산된 스코빌 지수를 다시 큐에 넣기
         answer++;
      }
      return pq.peek() >=K?answer:-1;
   }
}