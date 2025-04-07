import java.util.*;

//
class Solution {
   public int solution(int distance, int[] rocks, int n) {
      int answer = 0;
      Arrays.sort(rocks);
      int left = 1;
      int right = distance;

      int[] newRocks = Arrays.copyOf(rocks, rocks.length + 1);
      newRocks[newRocks.length - 1] = distance;

      while (left <= right) {
         int mid = (left + right) / 2;
         int prev = 0;
         int count = 0;

         for (int i = 0; i < newRocks.length; i++) {
            int diff = newRocks[i] - prev;
            if (diff < mid) count++;
            else prev = newRocks[i];
         }

         if (count > n) right = mid - 1;
         else {
            answer = mid;
            left = mid + 1;
         }
      }
      return answer;
   }
}