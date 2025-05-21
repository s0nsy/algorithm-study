import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(st.nextToken());
      Set<int[]>[] set = new HashSet[V+1];
      for (int i = 1; i <= V; i++)
         set[i] = new HashSet<>();
      for (int i = 0; i < E; i++) {
         st = new StringTokenizer(br.readLine());
         int v1 = Integer.parseInt(st.nextToken());
         int v2 = Integer.parseInt(st.nextToken());
         int len = Integer.parseInt(st.nextToken());
         set[v1].add(new int[] { v2, len });

      }
      int[] answer = new int[V + 1];
      Arrays.fill(answer, E * 10 + 1);
      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
      pq.offer(new int[] { K, 0 });
      answer[K] = 0;

      while (!pq.isEmpty()) {
         int[] arr = pq.poll();
         if (set[arr[0]] == null)
            continue;

         for (int[] i : set[arr[0]]) {
            if (answer[i[0]] > arr[1] + i[1]) {
               answer[i[0]] = arr[1] + i[1];
               pq.offer(new int[] { i[0], answer[i[0]] });
            }

         }
      }
      for (int i = 1; i <= V; i++) {
         if (answer[i] == E * 10 + 1)
            System.out.println("INF");
         else
            System.out.println(answer[i]);
      }

   }
}
