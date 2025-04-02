import java.util.*;
//+10점
class Solution {
   public String solution(int[] numbers) {

      String[] arr = new String[numbers.length];
      for(int i =0;i<numbers.length;i++){
         arr[i]= String.valueOf(numbers[i]);
      }
      Arrays.sort(arr, (o1,o2)->(o2+o1).compareTo(o1+o2));// (o1+o2).compareTo(o2+o1) 면 가장 작은 값

      if(arr[0].equals("0")) return "0";

      StringBuilder sb = new StringBuilder();
      for(String i :arr){
         sb.append(i);
      }
      return sb.toString();

   }
}