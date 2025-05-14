import java.util.Arrays;
import java.util.Scanner;
// 182560kb	1092ms
public class Main{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int[][] arr = new int[N][2];
      for (int i = 0; i < N; i++) {
         arr[i][0] = sc.nextInt();
         arr[i][1] = sc.nextInt();
      }
      int max=0;
      int end=0;

      Arrays.sort(arr, (a, b) -> {
         if (a[1] == b[1])
            return Integer.compare(a[0], b[0]);
         else
            return Integer.compare(a[1], b[1]);
      });
      for(int i=0;i<N;i++){
         if(arr[i][0]>=end){
            end=arr[i][1];
            max++;
         }
      }
      System.out.println(max);
   }
}
// 183324kb	1084ms. 완전탐색
public class Main {
   static int N, max = 0;
   static int[][] arr;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      arr = new int[N][2];
      for (int i = 0; i < N; i++) {
         arr[i][0] = sc.nextInt();
         arr[i][1] = sc.nextInt();
      }

      Arrays.sort(arr, (a, b) -> {
         if (a[1] == b[1])
            return Integer.compare(a[0], b[0]);
         else
            return Integer.compare(a[1], b[1]);

      });
      if(arr[0][0]==arr[0][1]) // 같으면 첫 시작 회의가 합산되는데 다른 경우는 합산되지 않음
         greedy(0,0,0);
      else greedy(0, 0, 1);
      System.out.println(max);

   }

   public static void greedy(int prev, int next, int cnt) {
      if (next == N) {
         max = Math.max(cnt, max);
         return;
      }
      if (arr[prev][1] <= arr[next][0]) {
         greedy(next, next + 1, cnt + 1);
      } else
         greedy(prev, next + 1, cnt);
   }
}