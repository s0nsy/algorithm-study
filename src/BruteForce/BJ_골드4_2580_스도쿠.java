import java.util.Scanner;

public class Main {
   static int[][] sudoku;
   static boolean solved;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      sudoku = new int[9][9];
      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            sudoku[i][j] = sc.nextInt();
         }
      }
      bt(0, 0);
   }

   static void bt(int x, int y) {
      if(solved)
         return;
      if (y >= 9) {
         if (x >= 8) {
            solved=true;
            for (int[] i : sudoku) {
               for (int j : i) {
                  System.out.print(j + " ");
               }
               System.out.println();
            }
            return;
         } else
            bt(x + 1, 0);
         return;
      }

      if (sudoku[x][y] != 0) {
         bt(x, y + 1);
         return;
      }

      boolean[] isValid = new boolean[10];
      isValid[0] = true;
      // sudoku[x][y]값이 0일 때 같은 행, 열, 3*3에 0이 있을 수 있으므로 0 있는지 체크하기★
      for (int i = 0; i < 9; i++) {
         if (sudoku[i][y]!=0) isValid[sudoku[i][y]] = true;
         if (sudoku[x][i]!=0) isValid[sudoku[x][i]] = true;

      }
      for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
         for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
            if (sudoku[i][j]!=0)isValid[sudoku[i][j]] = true;
         }
      }
      for (int i = 0; i < 10; i++) {
         if (!isValid[i]) {
            sudoku[x][y] = i;
            bt(x, y + 1);
            sudoku[x][y]=0;
         }
      }
   }
}
