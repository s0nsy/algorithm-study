import java.util.*;
//+9점
class Solution {
   int[] distance;
   List<List<Integer>> graph;
   public int solution(int n, int[][] edge) {
      int answer =0;
      graph= new ArrayList<>();
      for(int i =0;i<=n;i++){
         graph.add(new ArrayList<>());
      }
      for(int[] i: edge){
         graph.get(i[0]).add(i[1]);
         graph.get(i[1]).add(i[0]);
      }
      distance = new int[n+1];
      Arrays.fill(distance,-1); //모두 방문 X
      distance[1]=0; //본인
      bfs();
      int max = 0;
      for(int dist: distance){
         if(dist>max){
            max= dist;
            answer=1;
         }else if(dist== max){
            answer++;
         }

      }
      return answer;
   }
   void bfs(){
      Queue<Integer> q = new LinkedList<>();
      q.offer(1);

      while(!q.isEmpty()){
         int node = q.poll();
         for(int next: graph.get(node)){ //연결된 간선 중
            if(distance[next]!=-1)
               continue;
            distance[next]= distance[node]+1;
            q.add(next);
         }
      }
   }
}