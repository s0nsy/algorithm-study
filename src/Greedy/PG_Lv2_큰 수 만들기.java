//+9점
//dfs
class Solution {
   public String solution(String number, int k) {
      StringBuilder answer = new StringBuilder();
      int start = 0;
      // 몇 번째 숫자인지.
      for(int i= 0;i<number.length()-k;i++){
         char max = '0';
         for(int j =start;j<=k+i;j++){
            if(number.charAt(j)>max){
               max = number.charAt(j);
               start= j+1;
            }
         }
         answer.append(max);
      }

      return answer.toString();
   }
}

//bfs

import java.util.*;
class Solution{
   public int solution(int n, int[][] computers) {
      int answer =0;
      boolean[] visited = new boolean[n];

      Queue<Integer> q = new LinkedList<>();
      for(int c= 0;c<n;c++){
         if(!visited[c]){
            q.add(c);

            while(!q.isEmpty()){
               int now= q.poll();
               visited[now]=true;

               for(int i=0;i<n;i++){
                  if(!visited[i]&&computers[now][i]==1){
                     visited[i]=true;
                     q.add(i);
                  }
               }
            }
            answer++;
         }
      }
      return answer;
   }

}