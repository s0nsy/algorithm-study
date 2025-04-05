//+10점
class Solution {
   public int solution(String name) {
      int answer = 0;
      int len = name.length();
      int move = len -1; // 한쪽으로 쭉 이동한 경우
      for(int i =0;i<len;i++){
         int ascii= (int) name.charAt(i);
         answer+=Math.min(ascii-65,90-ascii+1);

         int next = i+1;
         while(next<len&&name.charAt(next)=='A'){
            next++;
         }
         move= Math.min(move, Math.min(i*2+len-next, i+(len-next)*2));
      }

      return answer+move;
   }

}