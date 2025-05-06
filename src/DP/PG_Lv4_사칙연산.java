class Solution {
   //+8점
   public int solution(String arr[]) {
      int[][][] dp = new int[arr.length][arr.length][2];
      int[] answer = solve(dp,arr,0,arr.length-1);
      return answer[0];
   }
   int[] solve(int[][][] dp, String[] arr, int start, int end){
      if(start==end){
         int val = Integer.parseInt(arr[start]);
         return new int[]{val,val};
      }
      if(dp[start][end][0]!=0)
         return new int[]{dp[start][end][0],dp[start][end][1]};

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;

      for(int i = start+1;i<end;i+=2){

         int[] left = solve(dp,arr,start,i-1);
         int[] right = solve(dp,arr,i+1,end);

         char op = arr[i].charAt(0);

         for(int l : left)
            for(int r: right){
               int res = (op == '+') ? l+r: l-r;
               max = Math.max(res,max);
               min = Math.min(res,min);
            }
      }
      dp[start][end][0]=max;
      dp[start][end][1]=min;

      return new int[]{max,min};
   }
}