import java.util.*;
//+6점
class Solution {
   String[] answer = {};
   public String[] solution(String[][] tickets) {

      List<String> route;
      for(int i=0;i<tickets.length;i++){
         if(tickets[i][0].equals("ICN")){
            route = new ArrayList<>();
            boolean[] used = new boolean[tickets.length];
            route.add(tickets[i][0]);
            route.add(tickets[i][1]);
            used[i]=true;
            dfs(tickets,route, used);
         }
      }
      return answer;
   }
   void dfs(String[][] tickets, List<String> route,boolean[] used){
      for(int i =0;i<tickets.length;i++){
         if(route.size()==tickets.length+1){
            //new String[0]을 넣는 이유는 타입 안전성과 성능 때문
            answer=compareRoute(answer,route.toArray(new String[0]));
            return;
         }
         if(tickets[i][0].equals(route.get(route.size()-1))&&!used[i]){
            used[i]=true;
            route.add(tickets[i][1]);
            dfs(tickets,route,used);
            used[i]=false;
            route.remove(route.size()-1);
         }
      }
   }
   String[] compareRoute(String[] a, String[] b){
      if(a.length!=b.length)
         return b;
      for(int i=1;i<a.length;i++){
         if(a[i].compareTo(b[i])==0)
            continue;
         if(a[i].compareTo(b[i])<0)
            return a;
         else return b;
      }
      return a;
   }
}