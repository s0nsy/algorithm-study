import java.util.*;
// 314880kb	1176ms
public class Main{
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[][] arr = new int[n][4];
      int[] end = new int[3];
      end[0]=3;
      end[1]=1;
      end[2]=0;
      for(int i=0;i<n;i++) {
         for(int j =0;j<4;j++) {
            arr[i][j]=sc.nextInt();
         }
      }
      Arrays.sort(arr,(a,b)->{
         if(a[0]!=b[0]) return a[0]-b[0];
         return a[1]-b[1];
      });

      int endMonth=0;
      int endDay=0;
      int cnt =0;
      int day;
      while(endMonth<12) {
         boolean found= false;
         day=end[2];
         for(;day<n;day++) {
            if(arr[day][0]<end[0]||(arr[day][0]==end[0]&&arr[day][1]<=end[1])) {
               if(arr[day][2]>endMonth||(arr[day][2]==endMonth&&arr[day][3]>endDay)) {
                  endMonth=arr[day][2];
                  endDay=arr[day][3];
                  end[2]=day;
                  found=true;
               }

            }else break;
         }
         if(!found) {
            System.out.println(0);
            return;
         }
         end[0]=endMonth;
         end[1]=endDay;
         cnt++;
      }

      System.out.println(cnt);
   }
}

// 1차원 배열로 풀었을 때. 더욱 효율적이고 깔끔하게 풀 수 있다.
import java.io.*;
//46920kb 340ms
public class Main{
   static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st= new StringTokenizer(br.readLine());
      int[] endDays = new int[366];
      int n = Integer.parseInt(st.nextToken());
      for(int i=0;i<n;i++) {
         st= new StringTokenizer(br.readLine());
         int startM=Integer.parseInt(st.nextToken());
         int startD=Integer.parseInt(st.nextToken());
         int endM=Integer.parseInt(st.nextToken());
         int endD=Integer.parseInt(st.nextToken());

         int start = getDay(startM,startD);
         int end = getDay(endM,endD);

         endDays[start]=Math.max(end,endDays[start]);
      }

      int cnt =0;
      int start = 1;
      int end = 60; // 3월 1일
      // start ~ end일 사이에 피는 꽃 중 가장 멀리까지 가는 꽃을 선택
      while(end<335) { //12월 1일
         int next =0;
         for(int i = start;i<=end;i++) {
            next=Math.max(endDays[i],next);
         }

         if(next==0) break;

         start=end;
         end = next;
         cnt++;
      }
      if(end>=335) System.out.println(cnt);
      else System.out.println(0);

   }
   static int getDay(int month,int day) {
      int count=0;
      for(int i=0;i<month;i++) {
         count+=days[i];
      }
      count+=day;
      return count;
   }
}
