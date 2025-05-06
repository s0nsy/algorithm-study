import java.util.*;
//+8점
//kruskal
class Solution {
   public int solution(int n, int[][] costs) {
      int answer = 0;
      int[] tree = new int[n];
      Arrays.sort(costs,(a,b)->a[2]-b[2]);
      for(int i=0;i<tree.length;i++) tree[i]=i;
      int cnt=0;
      for(int i =0;i<costs.length;i++){
         int a = costs[i][0];
         int b = costs[i][1];
         int len = costs[i][2];


         if(find(a,tree) !=find(b,tree)){
            union(a,b,tree);
            answer+=len;
            cnt++;
            if(cnt==n-1)
               break;
         }
      }

      return answer;
   }
   int find(int x, int[] tree){
      if(tree[x]==x) return x;
      return tree[x]= find(tree[x],tree);
   }

   void union(int a, int b, int[] tree){
      int rootA= find(a,tree);
      int rootB= find(b,tree);
      if(rootA!=rootB)
         tree[rootA]=rootB;
   }
}


//prim
class Solution {
   public int solution(int n, int[][] costs) {
      int answer =0;
      boolean[] visited = new boolean[n];
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
      visited[0]=true;
      for(int i =0;i<costs.length;i++){
         if(costs[i][0]==0||costs[i][1]==0)
            pq.offer(new int[]{costs[i][0]==0? costs[i][1]:costs[i][0],costs[i][2]});
      }

      int cnt =0;
      while(!pq.isEmpty()&&cnt<n-1){
         int[] arr = pq.poll();
         int node =arr[0];
         int cost = arr[1];

         if(visited[node])
            continue;

         visited[node]=true;
         cnt++;
         answer +=cost;
         for(int i =0;i<costs.length;i++){
            if(costs[i][1]==node&&!visited[costs[i][0]])
               pq.offer(new int[]{costs[i][0],costs[i][2]});
            else if(costs[i][0]==node&&!visited[costs[i][1]])
               pq.offer(new int[]{costs[i][1],costs[i][2]});
         }
      }
      return answer;
   }
}