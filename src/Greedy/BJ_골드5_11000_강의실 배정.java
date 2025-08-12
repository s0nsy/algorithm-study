import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
// 313624kb	1264ms
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      // 시작시간 기준 정렬
      int[][] arr = new int[n][2];
      for (int i = 0; i < n; i++) {
         arr[i][0] = sc.nextInt();
         arr[i][1] = sc.nextInt();
      }

      Arrays.sort(arr, (a, b) -> {
         if (a[0] == b[0])
            return Integer.compare(a[1], b[1]);
         else
            return Integer.compare(a[0], b[0]);
      });

      PriorityQueue<Integer> pq = new PriorityQueue<>();
      pq.offer(arr[0][1]);
      for (int i = 1; i < n; i++) {
         if (pq.peek() <= arr[i][0]) {
            pq.poll();
         }
         pq.offer(arr[i][1]);
      }
      System.out.println(pq.size());
   }
}
