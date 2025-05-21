import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      List<int[]>[] ls = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
         ls[i] = new ArrayList<>();
      }
      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         int v1 = Integer.parseInt(st.nextToken());
         int v2 = Integer.parseInt(st.nextToken());
         int len = Integer.parseInt(st.nextToken());
         ls[v1].add(new int[] { v2, len });
      }
      // 최대 10000*499 이니까 long
      long[] answer = new long[N + 1];
      Arrays.fill(answer, Long.MAX_VALUE);
      answer[1] = 0;

      // 도시가 N개면 최단 경로는 N-1개를 거쳐서 구할 수 있다.
      for (int i = 0; i < N - 1; i++) {
         // 현재 알고 있는 최단 거리보다 더 짧은 경로가 있는지 확인
         for (int j = 1; j <= N; j++) {
            for (int[] l : ls[j]) {
               if (answer[j] != Long.MAX_VALUE && answer[l[0]] > answer[j] + l[1])
                  answer[l[0]] = answer[j] + l[1];

            }
         }
      }
      // 음수 사이클 존재 확인 (간선 N-1개 확인 이후의 상황에서 갱신이 일어나는지)
      for (int i = 1; i <= N; i++) {
         for (int[] l : ls[i]) {
            if (answer[i] != Long.MAX_VALUE && answer[l[0]] > answer[i] + l[1]) {
               System.out.println(-1);
               return;

            }
         }
      }
      for (int i = 2; i <= N; i++) {
         if (answer[i] == Long.MAX_VALUE)
            bw.write(-1 + "\n");
         else
            bw.write(answer[i] + "\n");
      }
      bw.flush();
      bw.close();
   }
}
