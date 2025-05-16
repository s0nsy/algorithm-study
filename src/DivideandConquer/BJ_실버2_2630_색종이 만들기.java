import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 16780kb	172ms
public class Main {
   static int[][] arr;
   static int N, blue = 0, white = 0;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      arr = new int[N][N];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      solve(0, 0, N);
      System.out.println(white + "\n" + blue);
   }

   static void solve(int x, int y, int size) {
      if (y >= N || x >= N)
         return;

      int color = arr[x][y];
      for (int i = x; i < x + size; i++) {
         for (int j = y; j < y + size; j++) {
            if (color != arr[i][j]) {
               solve(x, y, size / 2);
               solve(x, y + size / 2, size / 2);
               solve(x + size / 2, y, size / 2);
               solve(x + size / 2, y + size / 2, size / 2);
               return;
            }
         }
      }
      if (color == 1)
         blue++;
      else
         white++;
   }
}