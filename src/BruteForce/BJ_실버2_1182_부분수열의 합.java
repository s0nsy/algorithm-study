import java.util.Scanner;
// 17692KB	180ms
public class Main {
   static int[] arr;
   static int cnt = 0, S;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      S = sc.nextInt();
      arr = new int[N];
      for (int i = 0; i < N; i++) {
         arr[i] = sc.nextInt();
      }
      cal(0, 0);
      if(S==0) cnt--;
      System.out.println(cnt);
   }

   public static void cal(int j, int sum) {
      if (j == arr.length) {
         if (sum == S)
            cnt++;
         return;
      }

      cal(j + 1, sum + arr[j]);
      cal(j + 1, sum);
   }
}