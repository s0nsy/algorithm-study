import java.util.*;

class Solution {
   public int solution(int[] priorities, int location) {
      int answer = 0;
      boolean[] visited = new boolean[priorities.length];
      Deque<int[]> q = new ArrayDeque<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

      for(int i =0;i<priorities.length;i++){
         q.offer(new int[]{priorities[i],i});
         pq.offer(priorities[i]);
      }

      while(true){
         int[] p = q.poll();

         if(p[0]<pq.peek()){
            q.offer(new int[]{p[0],p[1]});
         }else{
            answer++;
            if(p[1]==location) break;
            pq.poll();
         }
      }
      return answer;
   }
}