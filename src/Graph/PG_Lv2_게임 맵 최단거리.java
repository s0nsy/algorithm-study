

//bfs
//dfs+백트래킹 -> bfs 보다 효율성 떨어진다
import java.util.*;
//+5점
class Solution {
   int[] dx={-1,0,1,0};
   int[] dy={0,-1,0,1};
   int answer=10001;
   public int solution(int[][] maps) {
      boolean[][] visited= new boolean[maps.length][maps[0].length];
      visited[0][0]=true;
      bfs(maps,visited);
      //dfs(maps,visited,0,0,1);
      return answer!=10001? answer: -1;
   }
   void bfs(int[][] maps, boolean[][] visited){
      Queue<Node> q = new LinkedList<>();
      q.add(new Node(0,0,1));

      while(!q.isEmpty()){
         Node node = q.poll();
         if(node.x==maps.length-1&&node.y == maps[0].length-1){
            answer=Math.min(answer,node.cnt);
         }
         for(int d = 0;d<4;d++){
            int nx = dx[d]+ node.x;
            int ny = dy[d]+ node.y;
            if(nx>=maps.length||ny>=maps[0].length||nx<0||ny<0)
               continue;

            if(!visited[nx][ny]&&maps[nx][ny]==1){
               visited[nx][ny]=true;
               q.add(new Node(nx,ny, node.cnt+1));
            }
         }
      }

   }
   void dfs(int[][] maps,boolean[][] visited, int x, int y, int cnt){
      if(x==maps.length-1&&y==maps[0].length-1){
         answer= Math.min(answer,cnt);
         return;
      }
      for(int d=0;d<4;d++){
         int nx = dx[d]+x;
         int ny = dy[d]+y;
         if(nx>=maps.length||ny>=maps[0].length||nx<0||ny<0)
            continue;

         if(!visited[nx][ny]&&maps[nx][ny]==1){
            visited[nx][ny]=true;
            dfs(maps,visited, nx, ny, cnt+1);
            visited[nx][ny]=false;
         }
      }

   }
}
class Node{
   int x;
   int y;
   int cnt;
   Node(int x, int y, int cnt){
      this.x = x;
      this.y = y;
      this.cnt = cnt;
   }
}