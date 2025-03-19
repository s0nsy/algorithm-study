import java.util.*;

//+15점
class Solution {
   public int solution(int n, int[] lost, int[] reserve) {
      int answer = n;
      int[] clothes = new int[n + 2];
      Arrays.fill(clothes, 1);
      for (int i : lost) {
         clothes[i] -= 1;
      }
      for (int i : reserve) {
         clothes[i] += 1;
      }
      for (int i : clothes) {
         if (i == 0)
            answer--;
      }

      for (int i = 1; i < n + 1; i++) {
         if (clothes[i] == 0)
            if (clothes[i - 1] == 2) {
               clothes[i - 1] = 1;
               answer++;
            } else if (clothes[i + 1] == 2) {
               clothes[i + 1] = 1;
               answer++;
            }
      }
      return answer;
   }
}