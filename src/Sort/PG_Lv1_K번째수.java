import java.util.*;


//+2점
class Solution {
   public List<Integer> solution(int[] array, int[][] commands) {
      List<Integer> cut;
      List<Integer> answer = new ArrayList<>();
      for(int i=0;i<commands.length;i++){
         cut = new ArrayList<>();
         for(int t =commands[i][0];t<=commands[i][1];t++){
            cut.add(array[t-1]);
         }
         Collections.sort(cut);
         answer.add(cut.get(commands[i][2]-1));

      }
      return answer;
   }
}


//최적화한 코드
class Solution{
   public int[] solution(int[] array, int[][] commands) {
      int[] answer = new int[commands.length];

      for(int i =0;i<commands.length;i++){
         int start = commands[i][0]-1;
         int end = commands[i][1];
         int k = commands[i][2]-1;

         int[] cut = Arrays.copyOfRange(array, start, end); // 배열 복사 메서드 Arrays.copyOfRagne(복사할 배열, 복사 시작 인덱스, 복사 끝낼 인덱스)
         Arrays.sort(cut);

         answer[i]= cut[k];
      }
      return answer;
   }
}