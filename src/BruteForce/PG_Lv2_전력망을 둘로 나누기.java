//+2점
class Solution {
   public int solution(int n, int[][] wires) {
      int answer =n;
      int cnt =0;
      for(int i =0;i<wires.length;i++){
         boolean[] visited = new boolean[n+1];
         cnt = dfs(i,wires[i][0],visited, wires);
         // 시작 노드를 자연수로 작성하지 말고 안전하게 배열 안에 있는 값 사용하기
         answer = Math.min(Math.abs(n-cnt-cnt),answer);
      }
      return answer;
   }
   int dfs(int cutWire, int node, boolean[] visited, int[][] wires){
      visited[node]=true;
      int cnt = 1; // 자기 자신 포함하기
      for(int i =0;i<wires.length;i++){
         if(i==cutWire)
            continue;
         if(wires[i][1]==node&&!visited[wires[i][0]]){
            cnt += dfs(i,wires[i][0],visited,wires);
         }else if(wires[i][0]==node&&!visited[wires[i][1]]){
            cnt += dfs(i,wires[i][1],visited,wires);
         }
      }
      return cnt;
   }
}