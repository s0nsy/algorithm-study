
//+6점

import java.util.*;

class Solution {
   public int[] solution(int[] answers) {
      int[] first = {1, 2, 3, 4, 5};
      int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
      int[] third = {3, 1, 2, 4, 5};

      int[] checks = new int[3];
      //점수 계산
      for (int i = 0; i < answers.length; i++) {
         if (first[i % 5] == answers[i])
            checks[0]++;
         if (second[i % 8] == answers[i])
            checks[1]++;
         if (third[(i / 2) % 5] == answers[i])
            checks[2]++;
      }
      List<Integer> check = new ArrayList<>();

      //최대 점수 구하기
      int max = Math.max(checks[0], Math.max(checks[1], checks[2]));

      //최대 점수인 사람 구하기
      for (int i = 0; i < 3; i++) {
         if (max == checks[i])
            check.add(i + 1);
      }

      int[] answer = new int[check.size()];
      for (int i = 0; i < check.size(); i++) {
         answer[i] = check.get(i);
      }
      Arrays.sort(answer);

      return answer;
   }
}