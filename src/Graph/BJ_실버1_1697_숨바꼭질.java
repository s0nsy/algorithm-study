import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 31076kb	216ms
public class Main {
   static int N, K;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      K = sc.nextInt();
      if (N > K) {
         System.out.println(N - K);
         return;
      }
      boolean[] visited= new boolean[100001];
      Queue<Coor> q = new LinkedList<>();
      q.add(new Coor(N, 0));

      while (!q.isEmpty()) {
         Coor coor = q.poll();
         int now = coor.now;
         int cnt = coor.cnt;
         if (now == K) {
            System.out.println(cnt);
            break;
         } else if (now > 100000 || now < 0)
            continue;
         if(visited[now])
            continue;
         visited[now]=true;
         q.add(new Coor(now * 2, cnt + 1));
         q.add(new Coor(now + 1, cnt + 1));
         q.add(new Coor(now - 1, cnt + 1));

      }
   }
}

class Coor {
   int now;
   int cnt;

   Coor(int now, int cnt) {
      this.now = now;
      this.cnt = cnt;
   }

}