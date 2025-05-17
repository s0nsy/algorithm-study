import java.util.Arrays;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();

      int[] arr = new int[n];
      int[] coin = new int[100001];
      // value를 100001이 아닌 Integer.MAX_VALUE로 진행하게 되면
      // 라인29의 coin[i-arr[j]]+1에서 오버플로우가 발생하여 음수가 된다.
      // coin[i - arr[j]]가 MAX인 경우를 생각해야 한다.
      Arrays.fill(coin, 100001);

      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
         coin[arr[i]] = 1;
      }

      // coin[] 인덱스는 값, 값은 코인 수

      for (int i = 2; i <= k; i++) {
         for (int j = 0; j < n; j++) {
            if (i - arr[j] <= 0)
               continue;
            coin[i] = Math.min(coin[i - arr[j]] + 1, coin[i]);
         }
      }

      if (coin[k] == 100001)
         System.out.println(-1);
      else
         System.out.println(coin[k]);
   }
}