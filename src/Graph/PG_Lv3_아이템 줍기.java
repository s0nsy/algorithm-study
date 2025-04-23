import java.util.*;
//+6점
class Solution {
   public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
      int[] dx = {-1,0,1,0};
      int[] dy = {0,-1,0,1};

      boolean[][] visited = new boolean[101][101];
      int[][] path = new int[101][101];
      characterX*=2;
      characterY*=2;
      itemX*=2;
      itemY*=2;
      for(int[] i: rectangle){

      }
      for(int i =0;i<rectangle.length;i++){
         rectangle[i][0]*=2;
         rectangle[i][1]*=2;
         rectangle[i][2]*=2;
         rectangle[i][3]*=2;
         for(int j =rectangle[i][0];j<=rectangle[i][2];j++){
            for(int k = rectangle[i][1];k<=rectangle[i][3];k++){
               if(j>rectangle[i][0]&&j<rectangle[i][2]&&k>rectangle[i][1]&&k<rectangle[i][3])
                  path[j][k]=2; //내부
               else if(path[j][k]!=2)
                  path[j][k]=1; //테두리

            }
         }
      }

      Queue<Node> q = new LinkedList<>();
      q.add(new Node(characterX, characterY,0));
      visited[characterX][characterY]=true;
      while(!q.isEmpty()){
         Node node = q.poll();

         if(node.x==itemX&&node.y==itemY){
            return node.len/2;
         }

         for(int i =0;i<4;i++){
            int nx = dx[i]+node.x;
            int ny = dy[i]+node.y;
            if(nx<0||ny<0||nx>=101||ny>=101)
               continue;
            if(path[nx][ny]==1&&!visited[nx][ny]){
               q.add(new Node(nx,ny,node.len+1));
               visited[nx][ny]=true;
            }

         }
      }

      return 0;
   }
}
class Node{
   int x;
   int y;
   int len;
   Node(int x, int y,int len){
      this.x= x;
      this.y=y;
      this.len=len;
   }
}