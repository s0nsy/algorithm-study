//+9점
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