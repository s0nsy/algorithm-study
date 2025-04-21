//+2점
class Solution {
   int[] answer= new int[2];
   public int[] solution(int brown, int yellow) {
      for(int i =3;i<=(brown+yellow)/2+1;i++){
         if((brown+yellow)%i==0){
            track(brown,yellow,(brown+yellow)/i,i);
         }
      }

      return answer;
   }
   void track(int brown, int yellow, int width, int height){
      if(width<height)
         return;
      int checkBrown=2*width+(height-2)*2;
      int checkYellow=(width-2)*(height-2);
      if(checkBrown==brown&&checkYellow==yellow){
         answer[0]=width;
         answer[1]=height;
      }
   }
}