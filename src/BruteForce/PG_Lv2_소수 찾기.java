import java.util.*;
//+4점
class Solution{
   Set<Integer> set = new HashSet<>();
   public int solution(String numbers){
      boolean[] visited = new boolean[numbers.length()];
      track(numbers,"",visited);
      return set.size();
   }
   void track(String numbers, String str, boolean[] visited){
      if(!str.isEmpty()){
         int num = Integer.parseInt(str);
         if(isPrime(num))
            set.add(num);
      }

      for(int i =0;i<visited.length;i++){
         if(!visited[i]) {
            visited[i] = true;
            track(numbers, str+numbers.charAt(i), visited);
            visited[i]=false;
         }
      }
   }
   boolean isPrime(int num){
      if(num<2)
         return false;
      for(int i =2;i<num;i++){
         if(num%i==0)
            return false;
      }
      return true;
   }
}