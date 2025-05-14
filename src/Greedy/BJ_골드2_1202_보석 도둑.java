import java.util.*;
import java.io.*;
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      int[][] gem = new int[N][2];
      int[] bag = new int[K];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         gem[i][0] = Integer.parseInt(st.nextToken());
         gem[i][1] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < K; i++) {
         st = new StringTokenizer(br.readLine());
         bag[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(gem, (a, b) -> a[0] - b[0]);
      Arrays.sort(bag);
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      long sum = 0;
      int index = 0;
      for (int i = 0; i < K; i++) {

         while(index<N&&bag[i] >= gem[index][0]) {
            pq.offer(gem[index][1]);
            index++;
         }
         if (!pq.isEmpty())
            sum += pq.poll();

      }
      System.out.println(sum);
   }
}