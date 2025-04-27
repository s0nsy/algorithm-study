import java.util.*;
//+5점
class Solution {
   public int[] solution(String[] operations) {

      List<Integer> list = new ArrayList<>();
      for(int i =0;i<operations.length;i++){
         String cal = operations[i].substring(0,1);
         if(cal.equals("I"))
            list.add(Integer.parseInt(operations[i].substring(2)));
         if(cal.equals("D")){
            if(list.size()==0)
               continue;
            Collections.sort(list);
            if(operations[i].substring(2).equals("1"))
               list.remove(list.size()-1);
            else if(operations[i].substring(2).equals("-1"))
               list.remove(0);
         }

      }

      if(list.size()==0)
         return new int[]{0,0};

      Collections.sort(list);
      int[] answer = {list.get(list.size()-1),list.get(0)};

      return answer;
   }
}