import java.util.*;
//+3점
class Solution {
   public int solution(String begin, String target, String[] words) {
      int answer = words.length;
      boolean[] visited = new boolean[words.length];
      Queue<Node> q = new LinkedList<>();
      boolean exist = false;
      for (int i = 0; i < words.length; i++) {
         if (words[i].equals(target))
            exist = true;
      }
      if (!exist)
         return 0;
      q.add(new Node(begin, 0));
      while (!q.isEmpty()) {
         Node node = q.poll();
         String str = node.word;
         int cnt = node.cnt;

         if (str.equals(target))
            answer = Math.min(cnt, answer);
         for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < str.length(); j++) {
               String st = str.substring(0, j) + str.substring(j + 1, str.length());
               if (!visited[i] && st.equals(words[i].substring(0, j) + words[i].substring(j + 1, str.length()))) {
                  visited[i] = true;
                  q.add(new Node(words[i], cnt + 1));
               }

            }
         }
      }

      return answer;
   }
}

class Node {
   String word;
   int cnt;

   Node(String word, int cnt) {
      this.word = word;
      this.cnt = cnt;
   }
}