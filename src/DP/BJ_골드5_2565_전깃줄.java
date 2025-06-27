import java.util.*;
// 17784kb 184ms
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int[][] arr = new int[N][2];

      for(int i=0;i<N;i++) {
         arr[i][0]=sc.nextInt();
         arr[i][1]=sc.nextInt();
      }
      Arrays.sort(arr,(a,b)->a[0]-b[0]);

      int[] dp = new int[N];
      for(int i =0;i<N;i++) {
         for(int j =0;j<i;j++) {
            if(arr[i][1]>arr[j][1])
               // dp[i]는 인덱스 0부터 i까지 값에서 오름차순으로 올라가는 최대 개수를 뜻한다.
               dp[i]=Math.max(dp[i],dp[j]+1);

         }
      }
      Arrays.sort(dp);

      System.out.println(N-dp[N-1]-1);
   }
}
