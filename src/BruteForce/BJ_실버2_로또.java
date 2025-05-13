import java.util.*;
// 19548KB, 244ms
public class Main{
   static int[] arr;
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      while(true){
         int cnt = sc.nextInt();
         if(cnt==0)
            break;
         arr = new int[cnt];
         for(int i=0;i<cnt;i++){
            arr[i]=sc.nextInt();
         }
         rotto(0,0,"");
         System.out.println();
      }

   }
   public static void rotto(int i,int cnt, String str){
      if(cnt==6){
         System.out.println(str);
         return;
      }
      for(int j=i;j<arr.length;j++){
         rotto(j+1,cnt+1,str+Integer.toString(arr[j])+" ");
      }
   }
}