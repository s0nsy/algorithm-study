//+1점
class Solution {
   public int solution(String word) {
      int answer = 0;
      // 단어 길이가 최대 5라 하드코딩으로 진행.
      int[] weight={781,156,31,6,1};
      int len = word.length();
      for(int i =0;i<len;i++){
         char alpha = word.charAt(i);
         switch(alpha){
            case 'E':
               answer+=weight[i];
               break;
            case 'I':
               answer+=weight[i]*2;
               break;
            case 'O':
               answer+=weight[i]*3;
               break;
            case 'U':
               answer+=weight[i]*4;
               break;
         }
         answer+=1;
      }

      return answer;
   }
}
//switch 대신 더 간결하게 풀이 가능.
//int index = "AEIOU".indexOf(word.charAt(i));
//answer += weight[i] * index;