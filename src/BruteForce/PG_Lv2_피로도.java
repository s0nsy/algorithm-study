//+3점
class Solution {
   int max=0;
   public int solution(int k, int[][] dungeons) {
      boolean[] visited = new boolean[dungeons.length];

      dfs(k,dungeons,0,visited);
      return max;
   }
   void dfs(int k, int[][] dungeons, int answer, boolean[] visited){
      for(int i =0; i<dungeons.length;i++){
         if(!visited[i]&&k>=dungeons[i][0]){
            visited[i]=true;
            dfs(k-dungeons[i][1],dungeons,answer+1,visited);
            visited[i]=false;
         }
      }
      max = Math.max(max, answer);
   }
}