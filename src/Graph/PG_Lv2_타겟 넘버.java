import java.util.*;
//+2점
class Solution {
   int[] number;
   int result=0, answer=0;
   public int solution(int[] numbers, int target) {
      number = new int[numbers.length];
      result = target;
      for(int i=0;i<number.length;i++){
         number[i]=numbers[i];
      }

      dfs(0,0);
      return answer;
   }
   public void dfs(int cnt, int depth){

      if(depth>=number.length){
         if(cnt==result)ㅎㄷ
            answer++;
         return;
      }
      dfs(cnt+number[depth],depth+1);

      dfs(cnt-number[depth],depth+1);
   }
}

//최적화 코드
class Solution {
   public int solution(int[] numbers, int target) {
      int answer=0;
      answer= dfs(numbers,target, 0,0);
      return answer;
   }
   public int dfs(int[] numbers, int target, int cnt, int depth){

      if(depth>=numbers.length){
         if(target==cnt) {
            return 1;
         }
         return 0;
      }

      return dfs(numbers, target,cnt+numbers[depth],depth+1)+dfs(numbers,target,cnt-numbers[depth],depth+1);
   }
}
