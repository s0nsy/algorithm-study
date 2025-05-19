import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 14364kb 108ms
// bfs풀이는 네이버 블로그에.
public class Main {
   static int N, now = 0;
   static int[][] arr;
   static boolean[][] visited;
   static int[] dx = { 0, -1, 0, 1 };
   static int[] dy = { -1, 0, 1, 0 };
   static int[] answer;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());
      arr = new int[N][N];
      answer = new int[N * N];
      for (int i = 0; i < N; i++) {
         String line = br.readLine();
         for (int j = 0; j < N; j++) {
            arr[i][j] = line.charAt(j) - '0';
         }
      }
      visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            if (!visited[i][j] && arr[i][j] == 1) {
               visited[i][j]=true;
               answer[now]=1;
               dfs(i, j);
               now++;
            }
         }
      }
      Arrays.sort(answer,0,now);
      System.out.println(now);
      for (int i = 0; i < now; i++) {
         System.out.println(answer[i]);
      }

   }

   static void dfs(int i, int j) {

      for (int t = 0; t < 4; t++) {
         int nx = dx[t] + i;
         int ny = dy[t] + j;
         if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] == 0)
            continue;
         if(arr[nx][ny]==1) {
            visited[nx][ny] = true;
            answer[now]++;
            dfs(nx, ny);
         }

      }
   }
}
