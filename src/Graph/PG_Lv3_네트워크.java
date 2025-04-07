//+5점
class Solution {
   boolean[] visited;
   public int solution(int n, int[][] computers) {
      int answer = 0;
      visited = new boolean[n];
      for(int i =0;i<computers.length;i++){
         if(!visited[i]){
            dfs(n, computers, i);
            answer++;
         }
      }

      return answer;
   }
   void dfs(int n , int[][] computers, int check){
      for(int i =0;i<n;i++){
         if(i==check)
            continue;
         if(!visited[i]&&computers[check][i]==1){
            visited[i]=true;
            dfs(n, computers,i);
         }
      }
   }

}