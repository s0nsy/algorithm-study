import java.io.*;

//+3점
class Solution {
   public int solution(int[][] sizes) {
      int answer = 0;
      int w = 0;
      int h = 0;
      for (int i = 0; i < sizes.length; i++) {
         if (sizes[i][0] > sizes[i][1]) {
            int tmp = sizes[i][0];
            sizes[i][0] = sizes[i][1];
            sizes[i][1] = tmp;
         }
         w = Math.max(w, sizes[i][0]);
         h = Math.max(h, sizes[i][1]);
      }
      answer = w * h;
      return answer;
   }
}

// 효율적인 답안
class Solution {
   public int solution(int[][] sizes) {
      int answer = 0;
      int w = 0;
      int h = 0;
      for (int card[] : sizes) {
         w = Math.max(w, Math.max(card[0], card[1]));
         h = Math.max(h, Math.min(card[0], card[1]));
      }
      answer = w * h;
      return answer;
   }
}