import java.util.Scanner;
// 17616kb 172ms
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int A = sc.nextInt();
      int B = sc.nextInt();
      int C = sc.nextInt();

      System.out.println(solve(A, B, C));
   }

   static int solve(int a, int b, int c) {
      if (b == 1)
         return a % c;
      long res = solve(a, b / 2, c);
      if (b % 2 == 1)
         return (res * res % c) * a % c; // res*res*a%c의 경우 long의 범위를 넘어설 수 있음. 주의
      else return res * res % c;
   }
}