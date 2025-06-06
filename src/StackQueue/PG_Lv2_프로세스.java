import java.util.*;

class Solution {
   public int solution(int[] priorities, int location) {
      int answer = 0;
      Deque<int[]> q = new ArrayDeque<>(); // 순서를 유지하기 위해 앞뒤로 poll 가능한 deque 사용
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                                        // 가장 높은 중요도. 우선순위는 숫자가 낮을수록 높기 때문에 내림차순.

      for(int i =0;i<priorities.length;i++){
         q.offer(new int[]{priorities[i],i});
         pq.offer(priorities[i]);
      }

      while(true){
         int[] p = q.poll(); // 맨 앞 문서 꺼내기

         if(p[0]<pq.peek()){ // 해당 문서의 중요도보다 더 높은 중요도가 있으면
            q.offer(new int[]{p[0],p[1]}); // 다시 맨 뒤로 보내기
         }else{
            answer++;
            if(p[1]==location) break; // 해당 문서가 위치가 location이면 끝내기
            pq.poll();
         }
      }
      return answer;
   }
}