import java.util.*;

//+6점
class Solution {
   public int solution(int bridge_length, int weight, int[] truck_weights) {
      int answer = 0;
      Deque<Integer> dq = new LinkedList<>();
      int[][] truck = new int[truck_weights.length][2];

      for(int i =0;i<truck_weights.length;i++){
         truck[i][0]=truck_weights[i];
      }

      dq.add(0);
      truck[0][1]++;
      answer++;
      while(!dq.isEmpty()){
         //poll을 한 후에 lastIndex를 잡는 경우 dq가 비어있을 수 있으므로 미리 구해놓기
         int lastIndex = dq.peekLast();
         //다리 위에 있는 트럭 이동
         for(int i: dq){
            truck[i][1]++;
         }
         //다리를 건넌 트럭 dq에서 제거
         if(truck[dq.peek()][1]>bridge_length){
            dq.poll();
         }
         //다리 위에 있는 트럭의 합+새로운 트럭이 최대 무게 이하인지 확인하여 추가
         int sum =0;
         for(int i : dq){
            sum+=truck[i][0];
         }

         if(lastIndex+1<truck.length&&sum+truck[lastIndex+1][0]<=weight){
            dq.add(lastIndex+1);
            truck[lastIndex+1][1]++;
         }
         answer++;
      }
      return answer;
   }
}